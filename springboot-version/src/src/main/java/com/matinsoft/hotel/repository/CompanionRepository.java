package com.matinsoft.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.Companion;

@Repository
public interface CompanionRepository extends JpaRepository<Companion, Long>{

	List<Companion> findByGuestID(Integer guestId);

}
