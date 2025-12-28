package com.matinsoft.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.Companion;
import com.matinsoft.hotel.repository.CompanionRepository;
import com.matinsoft.hotel.repository.GuestRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.CompanionService;
import com.matinsoft.hotel.util.ValidationUtil;

import jakarta.transaction.Transactional;

@Service
public class CompanionServiceImpl implements CompanionService{

	private CompanionRepository companionRepository;
	private GuestRepository guestRepository;
	private ActivityHistoryService activityHistoryService;

	public CompanionServiceImpl(CompanionRepository theCompanionRepository,
			GuestRepository theGuestRepository, ActivityHistoryService theActivityHistoryService) {
		companionRepository=theCompanionRepository;
		guestRepository=theGuestRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public Companion save(Companion companion, Integer employeeId) {
		if (companion.getGuestID() == null
				|| companion.getFirstName() == null || companion.getFirstName().isBlank()
				|| companion.getLastName() == null || companion.getLastName().isBlank()
				|| companion.getCountry() == null || companion.getCountry().isBlank()
				|| companion.getNationalCode() == null || companion.getNationalCode().isBlank()) {
			throw new IllegalArgumentException("Required fields are missing");
		}

		// Guest must exist
		if (!guestRepository.existsById(companion.getGuestID())) {
			throw new IllegalArgumentException("Guest not found");
		}

		// First name & Last name
		ValidationUtil.validateName(companion.getFirstName(), "First name");

		ValidationUtil.validateName(companion.getLastName(), "Last name");

		//Country test
		companion.setCountry(companion.getCountry().toUpperCase().trim());
		ValidationUtil.validateCountry(companion.getCountry());

		//National code test
		ValidationUtil.validateNationalCode(companion.getNationalCode(), companion.getCountry());

		Companion saved = companionRepository.save(companion);

		activityHistoryService.log("COMPANION_CREATED", "Companion created for guest ID " + saved.getGuestID(),
                "COMPANION", saved.getCompanionID(), employeeId);

	    return saved;
	}

	@Transactional
	@Override
	public Companion update(Companion companion, Integer employeeId) {
		Companion existing = companionRepository.findById(companion.getCompanionID())
		        .orElseThrow(() -> new IllegalArgumentException("Companion not found"));

		// First name
		if (companion.getFirstName()!=null && !companion.getFirstName().isBlank()) {
			ValidationUtil.validateName(companion.getFirstName(), "First name");
			existing.setFirstName(companion.getFirstName());
		}

		// Last name
		if (companion.getLastName()!=null && !companion.getLastName().isBlank()) {
			ValidationUtil.validateName(companion.getLastName(), "Last name");
			existing.setLastName(companion.getLastName());
		}

		// Country
		if(companion.getCountry()!=null && !companion.getCountry().isBlank()) {
			companion.setCountry(companion.getCountry().toUpperCase().trim());
			ValidationUtil.validateCountry(companion.getCountry());
			ValidationUtil.validateNationalCode(existing.getNationalCode(), companion.getCountry());
			existing.setCountry(companion.getCountry());
		}

		// NationalCode
		if(companion.getNationalCode()!=null && !companion.getNationalCode().isBlank()) {
			ValidationUtil.validateNationalCode(companion.getNationalCode(), existing.getCountry());
			existing.setNationalCode(companion.getNationalCode());
		}
		Companion updated = companionRepository.save(existing);

		activityHistoryService.log("COMPANION_UPDATED", "Companion information updated",
                "COMPANION", updated.getCompanionID(), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Long id, Integer employeeId) {
	    if (!companionRepository.existsById(id)) {
	        throw new IllegalArgumentException("Companion not found");
	    }
	    companionRepository.deleteById(id);

	    activityHistoryService.log("COMPANION_DELETED", "Companion deleted",
                "COMPANION", id, employeeId);
	}

	@Transactional
	@Override
	public void deleteAll(List<Long> Ids, Integer employeeId) {

	    for (Long id:Ids) {
	        if (!companionRepository.existsById(id)) {
	            throw new IllegalArgumentException("Companion not found: " + id);
	        }
	    }
	    for (Long id:Ids) {
	    	 activityHistoryService.log("COMPANION_DELETED", "Companion deleted",
	                    "COMPANION", id, employeeId);
	    }

	    companionRepository.deleteAllById(Ids);
	}


	@Override
	public Companion findById(Long id) {
		return companionRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException("Companion not found"));
	}

	@Override
	public List<Companion> findAll() {
		return companionRepository.findAll();
	}

	@Override
	public List<Companion> findByGuestId(Integer guestId) {
		return companionRepository.findByGuestID(guestId);
	}
}