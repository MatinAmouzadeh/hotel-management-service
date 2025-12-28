package com.matinsoft.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.Companion;
import com.matinsoft.hotel.entity.Guest;
import com.matinsoft.hotel.repository.CompanionRepository;
import com.matinsoft.hotel.repository.GuestRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.GuestService;
import com.matinsoft.hotel.util.ValidationUtil;

import jakarta.transaction.Transactional;

@Service
public class GuestServiceImpl implements GuestService{

	private GuestRepository guestRepository;

	private CompanionRepository companionRepository;

	private ActivityHistoryService activityHistoryService;

	public GuestServiceImpl (GuestRepository theGuestRepository,
			CompanionRepository theCompanionRepository, ActivityHistoryService theActivityHistoryService) {
		guestRepository=theGuestRepository;
		companionRepository=theCompanionRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public Guest save(Guest guest, Integer employeeId) {
		//*********************************بعضی فیلد ها خالیه**************************************
		if (guest.getNationalCode()==null || guest.getNationalCode().isBlank()
				|| guest.getFirstName()==null || guest.getFirstName().isBlank()
				|| guest.getLastName()==null || guest.getLastName().isBlank()
				|| guest.getPhoneNumber()==null || guest.getPhoneNumber().isBlank()
				|| guest.getCountry()==null || guest.getCountry().isBlank()
				|| guest.getDateOfBirth()==null) {

			throw new IllegalArgumentException("Required guest fields are missing");
		}

		if (guestRepository.existsByNationalCode(guest.getNationalCode())) {
			throw new IllegalArgumentException("NationalCode already exists");
		}

		//First name & last name test
		ValidationUtil.validateName(guest.getFirstName(), "First name");

		ValidationUtil.validateName(guest.getLastName(), "Last name");

		//Country test
		guest.setCountry(guest.getCountry().toUpperCase().trim());
		ValidationUtil.validateCountry(guest.getCountry());

		//National code test
		ValidationUtil.validateNationalCode(guest.getNationalCode(), guest.getCountry());

		//Date of birth
		ValidationUtil.validateDateOfBirth(guest.getDateOfBirth());


		//PhoneNumber test
		ValidationUtil.validatePhone(guest.getPhoneNumber());

		//EmailAddress test -> optional
		if (guest.getEmailAddress()!=null && !guest.getEmailAddress().isBlank()) {
			ValidationUtil.validateEmail(guest.getEmailAddress());
		}

		Guest saved = guestRepository.save(guest);

		activityHistoryService.log("GUEST_CREATED", "Guest created", "GUEST",
                Long.valueOf(saved.getGuestID()), employeeId);

		return saved;
	}

	@Transactional
	@Override
	public Guest update(Guest guest, Integer employeeId) {
		Guest existing = guestRepository.findById(guest.getGuestID())
				.orElseThrow(() -> new IllegalArgumentException("Guest not found"));

		// First name
		if (guest.getFirstName()!=null && !guest.getFirstName().isBlank()) {
			ValidationUtil.validateName(guest.getFirstName(), "First name");
			existing.setFirstName(guest.getFirstName());
		}

		// Last name
		if (guest.getLastName()!=null && !guest.getLastName().isBlank()) {
			ValidationUtil.validateName(guest.getLastName(), "Last name");
			existing.setLastName(guest.getLastName());
		}

		// Country
		if(guest.getCountry()!=null && !guest.getCountry().isBlank()) {
			guest.setCountry(guest.getCountry().toUpperCase().trim());
			ValidationUtil.validateCountry(guest.getCountry());
			ValidationUtil.validateNationalCode(existing.getNationalCode(), guest.getCountry());
			existing.setCountry(guest.getCountry());
		}

		// NationalCode
		if(guest.getNationalCode()!=null && !guest.getNationalCode().isBlank()) {
			ValidationUtil.validateNationalCode(guest.getNationalCode(), existing.getCountry());
			existing.setNationalCode(guest.getNationalCode());
		}

		// Date of birth
		if (guest.getDateOfBirth()!=null) {
			ValidationUtil.validateDateOfBirth(guest.getDateOfBirth());
			existing.setDateOfBirth(guest.getDateOfBirth());
		}

		// Phone
		if (guest.getPhoneNumber()!=null && !guest.getPhoneNumber().isBlank()) {
			ValidationUtil.validatePhone(guest.getPhoneNumber());
			existing.setPhoneNumber(guest.getPhoneNumber());
		}

		// Email (optional)
		if (guest.getEmailAddress()!=null && !guest.getEmailAddress().isBlank()) {
			ValidationUtil.validateEmail(guest.getEmailAddress());
			existing.setEmailAddress(guest.getEmailAddress());
		}

		Guest updated = guestRepository.save(existing);

		activityHistoryService.log("GUEST_UPDATED", "Guest information updated", "GUEST",
                Long.valueOf(updated.getGuestID()), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Integer Id, Integer employeeId) {
		//Delete Guest = Delete companions

		if (!guestRepository.existsById(Id)) {
			throw new IllegalArgumentException("Guest not found");
		}

		List<Companion> companions=companionRepository.findByGuestID(Id);
		companionRepository.deleteAll(companions);

		guestRepository.deleteById(Id);

		 activityHistoryService.log("GUEST_DELETED", "Guest deleted", "GUEST",
	                Long.valueOf(Id), employeeId);
	}

	@Transactional
	@Override
	public void deleteAll(List<Integer> Ids, Integer employeeId) {
		for (Integer id:Ids) {
			if (!guestRepository.existsById(id)) {
				throw new IllegalArgumentException("Guest not found: " + id);
			}
		}
		//Delete Guest = Delete companions
		for (Integer id : Ids) {
		    List<Companion> companions = companionRepository.findByGuestID(id);
		    companionRepository.deleteAll(companions);
		}

		for (Integer id:Ids) {
			activityHistoryService.log("GUEST_DELETED", "Guest deleted", "GUEST",
                    Long.valueOf(id), employeeId);
		}

		guestRepository.deleteAllById(Ids);
	}

	@Override
	public Guest findById(Integer id) {
		return guestRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Guest not found"));
	}

	@Override
	public List<Guest> findAll() {
		return guestRepository.findAll();
	}
}//END OF CLASS