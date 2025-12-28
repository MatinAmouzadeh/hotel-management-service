package com.matinsoft.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.Payment;
import com.matinsoft.hotel.repository.PaymentRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.PaymentService;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepository;

	private ActivityHistoryService activityHistoryService;

	public PaymentServiceImpl(PaymentRepository thePaymentRepository,
			ActivityHistoryService theActivityHistoryService) {
		paymentRepository=thePaymentRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public Payment save(Payment payment, Integer employeeId) {
		if (payment.getReservationID()==null) {
			throw new IllegalArgumentException("Reservation ID is required");
		}

		if (payment.getAmount()<=0) {
			throw new IllegalArgumentException("Invalid payment amount");
		}

		if (payment.getStatus()==null || payment.getStatus().isBlank()) {
			throw new IllegalArgumentException("Payment status is required");
		}

		Payment saved=paymentRepository.save(payment);

		activityHistoryService.log("PAYMENT_CREATED", "Payment created", "PAYMENT",
                saved.getPaymentID().longValue(), employeeId);

		return saved;
	}

	@Transactional
	@Override
	public Payment update(Payment payment, Integer employeeId) {
		Payment existing=paymentRepository.findById(payment.getPaymentID())
				.orElseThrow(() -> new IllegalArgumentException(
						"Payment not found"));

		if ("PAID".equals(existing.getStatus())) {
			throw new IllegalStateException(
					"Cannot update a paid payment");
		}

		if (payment.getAmount()>0) {
			existing.setAmount(payment.getAmount());
		}

		if (payment.getStatus()!=null && !payment.getStatus().isBlank()) {
			existing.setStatus(payment.getStatus());
		}

		Payment updated=paymentRepository.save(existing);

		activityHistoryService.log("PAYMENT_UPDATED", "Payment updated", "PAYMENT",
                updated.getPaymentID().longValue(), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Integer id, Integer employeeId) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(
						"Payment not found"));

		if ("PAID".equals(payment.getStatus())) {
			throw new IllegalStateException("Cannot delete a paid payment");
		}

		paymentRepository.deleteById(id);

		activityHistoryService.log("PAYMENT_DELETED", "Payment deleted", "PAYMENT",
                id.longValue(), employeeId);
	}

	@Transactional
	@Override
	public void deleteAll(List<Integer> ids, Integer employeeId) {
		for (Integer id:ids) {
            Payment payment=paymentRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Payment not found: " + id));

            if ("PAID".equals(payment.getStatus())) {
                throw new IllegalStateException("Cannot delete paid payment: " +id);
            }
        }

        for (Integer id:ids) {
            activityHistoryService.log("PAYMENT_DELETED", "Payment deleted", "PAYMENT",
                    id.longValue(), employeeId);
        }

        paymentRepository.deleteAllById(ids);
	}

	@Override
	public Payment findById(Integer id) {
		return paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found"));
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment findByReservationId(Long reservationId) {
	    Payment payment = paymentRepository.findByReservationID(reservationId);
	    if (payment == null) {
	        throw new IllegalArgumentException("Payment not found");
	    }
	    return payment;
	}
}