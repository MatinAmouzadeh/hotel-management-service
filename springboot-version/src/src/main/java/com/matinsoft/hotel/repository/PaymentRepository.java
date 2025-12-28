package com.matinsoft.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	Payment findByReservationID(Long reservationId);

}
