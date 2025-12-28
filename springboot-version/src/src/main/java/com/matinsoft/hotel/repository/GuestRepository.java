package com.matinsoft.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer>{

	boolean existsByGuestID(Integer guestID);

	boolean existsByNationalCode(String NationalCode);
}
