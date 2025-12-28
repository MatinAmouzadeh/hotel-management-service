package com.matinsoft.hotel.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.dto.ReservationRequest;
import com.matinsoft.hotel.dto.ReservationResponse;
import com.matinsoft.hotel.entity.Payment;
import com.matinsoft.hotel.entity.Reservation;
import com.matinsoft.hotel.entity.Room;
import com.matinsoft.hotel.repository.EmployeeRepository;
import com.matinsoft.hotel.repository.GuestRepository;
import com.matinsoft.hotel.repository.PaymentRepository;
import com.matinsoft.hotel.repository.ReservationRepository;
import com.matinsoft.hotel.repository.RoomRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.ReservationService;

import jakarta.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationRepository reservationRepository;

	private GuestRepository guestRepository;

	private EmployeeRepository employeeRepository;

	private RoomRepository roomRepository;

	private PaymentRepository paymentRepository;

	private ActivityHistoryService activityHistoryService;

	public ReservationServiceImpl (ReservationRepository theReservationRepository,
			GuestRepository theGuestRepository, EmployeeRepository theEmployeeRepository
			, RoomRepository theRoomRepository, PaymentRepository thePaymentRepository
			, ActivityHistoryService theActivityHistoryService) {
		reservationRepository =theReservationRepository;
		guestRepository=theGuestRepository;
		employeeRepository=theEmployeeRepository;
		roomRepository=theRoomRepository;
		paymentRepository=thePaymentRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public ReservationResponse save(ReservationRequest reservationRequest, Integer employeeId) {

		if (employeeId == null || reservationRequest.getGuestId() == null
				|| reservationRequest.getDateOfArrival() == null || reservationRequest.getDepartureDate() == null) {
			throw new IllegalArgumentException("Required fields are missing");
		}

		// Time Test
		if (reservationRequest.getDepartureDate().isBefore(reservationRequest.getDateOfArrival())) {
			throw new IllegalArgumentException("Invalid date range");
		}

		// RoomID Test
		if (reservationRequest.getRoomIds() == null || reservationRequest.getRoomIds().isEmpty()) {
			throw new IllegalArgumentException("No rooms selected");
		}

		if (!guestRepository.existsById(reservationRequest.getGuestId())) {
			throw new IllegalArgumentException("Guest not found");
		}

		if (!employeeRepository.existsById(employeeId)) {
			throw new IllegalArgumentException("Employee not found");
		}

		for (int i = 0; i < reservationRequest.getRoomIds().size(); i++) {

			Room room = roomRepository.findById(reservationRequest.getRoomIds().get(i))
					.orElseThrow(() -> new IllegalArgumentException("Room not found"));

			if (!"AVAILABLE".equals(room.getStatus())) {
				throw new IllegalArgumentException("Room not available");
			}
		}

		// Create Reservation
		Reservation theReservation = new Reservation(LocalDateTime.now(),
				reservationRequest.getDateOfArrival(), reservationRequest.getDepartureDate(),
				employeeId,reservationRequest.getGuestId());

		// Nights
		long nights = ChronoUnit.DAYS.between(reservationRequest.getDateOfArrival().toLocalDate(),
				reservationRequest.getDepartureDate().toLocalDate());

		//>365-----> ERROR
		if (nights <= 0 || nights>365) {
			throw new IllegalArgumentException("Invalid stay duration");
		}

		Reservation respons = reservationRepository.save(theReservation);

		int totalPrice = 0;

		for (int i = 0; i < reservationRequest.getRoomIds().size(); i++) {

			Room room = roomRepository.findById(reservationRequest.getRoomIds().get(i))
			        .orElseThrow(() -> new IllegalArgumentException("Room not found"));

			room.setStatus("RESERVED");
			room.setReservationID(respons.getReservationID());
			roomRepository.save(room);

			totalPrice += room.getNightlyPrice()*Math.toIntExact(nights);
		}

		// Create Payment
		Payment payment = new Payment();
		payment.setReservationID(respons.getReservationID());
		payment.setAmount(totalPrice);
		payment.setStatus("PENDING");

		//Connecting to a banking portal
		payment.setMethod("ONLINE");
		payment.setCurrencyUnit("IRR");
		payment.setTransactionID("TX-"+ System.currentTimeMillis());//**********************************************************
		payment.setTime(LocalDateTime.now());

		paymentRepository.save(payment);

		activityHistoryService.log("PAYMENT_CREATED", "Payment created for reservation",
				"PAYMENT", payment.getPaymentID().longValue(), employeeId);

		activityHistoryService.log("RESERVATION_CREATED", "Reservation created successfully",
				"RESERVATION", respons.getReservationID(), employeeId);

		return new ReservationResponse("Reservation successful", respons.getReservationID(),
				"CONFIRMED", totalPrice,reservationRequest.getRoomIds());
	}

	@Transactional
	@Override
	public Reservation update(ReservationRequest reservationRequest, Integer employeeId) {

		if (employeeId == null) {
			throw new IllegalArgumentException("Employee Id is required");
		}

		if (reservationRequest.getReservationID() == null) {
			throw new IllegalArgumentException("Reservation ID is required for update");
		}

		Reservation existing = reservationRepository
				.findById(reservationRequest.getReservationID())
				.orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

		Payment payment = paymentRepository.findByReservationID(existing.getReservationID());
		if (payment == null) {
			throw new IllegalStateException("Payment not found for reservation");
		}
		if ("PAID".equals(payment.getStatus())) {
			throw new IllegalStateException("Cannot update reservation after payment");
		}

		LocalDateTime arrival;
		if (reservationRequest.getDateOfArrival()!=null) {
			arrival=reservationRequest.getDateOfArrival();
		}
		else {
			arrival=existing.getDateOfArrival();
		}

		LocalDateTime departure;
		if (reservationRequest.getDepartureDate()!=null) {
			departure=reservationRequest.getDepartureDate();
		}
		else {
			departure=existing.getDepartureDate();
		}

		if (departure.isBefore(arrival)) {
			throw new IllegalArgumentException("Invalid date range");
		}

		long nights=ChronoUnit.DAYS.between(arrival.toLocalDate(), departure.toLocalDate());
		if (nights<=0 || nights>365) {
			throw new IllegalArgumentException("Invalid stay duration");
		}

		List<Room> roomsForPricing;

		boolean changeRooms=(reservationRequest.getRoomIds()!=null && !reservationRequest.getRoomIds().isEmpty());

		if (changeRooms) {

			for (Integer roomId:reservationRequest.getRoomIds()) {
				Room room=roomRepository.findById(roomId)
						.orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomId));

				boolean sameReservation=(room.getReservationID()!=null && room.getReservationID().equals(existing.getReservationID()));
				if (!"AVAILABLE".equals(room.getStatus()) && !sameReservation) {
					throw new IllegalArgumentException("Room not available: " + roomId);
				}
			}

			List<Room> oldRooms=roomRepository.findByReservationID(existing.getReservationID());
			for (Room room:oldRooms) {
				room.setStatus("AVAILABLE");
				room.setReservationID(null);
				roomRepository.save(room);
			}

			for (Integer roomId:reservationRequest.getRoomIds()) {
				Room room = roomRepository.findById(roomId)
						.orElseThrow(() -> new IllegalArgumentException("Room not found"));;
						room.setStatus("RESERVED");
						room.setReservationID(existing.getReservationID());
						roomRepository.save(room);
			}

			roomsForPricing = roomRepository.findByReservationID(existing.getReservationID());
		}
		else {
			roomsForPricing=roomRepository.findByReservationID(existing.getReservationID());
		}

		int totalPrice=0;
		for (Room room:roomsForPricing) {
			totalPrice+= room.getNightlyPrice()*Math.toIntExact(nights);
		}

		payment.setAmount(totalPrice);
		payment.setStatus("PENDING");
		paymentRepository.save(payment);

		existing.setDateOfArrival(arrival);
		existing.setDepartureDate(departure);

		Reservation updated = reservationRepository.save(existing);

		activityHistoryService.log("RESERVATION_UPDATED", "Reservation updated",
				"RESERVATION", updated.getReservationID(), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Long id, Integer employeeId) {

		if (!reservationRepository.existsById(id)) {
			throw new IllegalArgumentException("Reservation not found");
		}

		List<Room> rooms=roomRepository.findByReservationID(id);
		for (int j=0; j<rooms.size(); j++) {
			Room room=rooms.get(j);
			room.setStatus("AVAILABLE");
			room.setReservationID(null);
			roomRepository.save(room);
		}
		reservationRepository.deleteById(id);

		activityHistoryService.log("RESERVATION_DELETED", "Reservation deleted",
				"RESERVATION", id, employeeId);

	}

	@Transactional
	@Override
	public void deleteAll(List<Long> ids, Integer employeeId) {
		for (Long id:ids) {
			if (!reservationRepository.existsById(id)) {
				throw new IllegalArgumentException("Reservation not found: " + id);
			}
		}

		for (int i = 0; i < ids.size(); i++) {

			Long reservationId = ids.get(i);

			List<Room> rooms = roomRepository.findByReservationID(reservationId);

			for (int j=0; j<rooms.size(); j++) {
				Room room=rooms.get(j);
				room.setStatus("AVAILABLE");
				room.setReservationID(null);
				roomRepository.save(room);
			}
			activityHistoryService.log("RESERVATION_DELETED", "Reservation deleted",
					"RESERVATION", reservationId, employeeId);

		}
		reservationRepository.deleteAllById(ids);
	}

	@Override
	public Reservation findById(Long id) {
		return reservationRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}
}
