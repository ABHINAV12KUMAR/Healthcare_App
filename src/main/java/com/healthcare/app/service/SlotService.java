package com.healthcare.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare.app.entity.AvailabilitySlot;
import com.healthcare.app.entity.Doctor;
import com.healthcare.app.entity.SlotStatus;
import com.healthcare.app.repository.DoctorRepository;
import com.healthcare.app.repository.SlotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SlotService {
	private final SlotRepository slotRepo;
	private final DoctorRepository doctorRepo;

	public AvailabilitySlot createSlot(Long doctorId, LocalDateTime start, LocalDateTime end) {

		Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));

		AvailabilitySlot slot = new AvailabilitySlot();
		slot.setDoctor(doctor);
		slot.setStartTime(start);
		slot.setEndTime(end);
		slot.setStatus(SlotStatus.ACTIVE);

		return slotRepo.save(slot);
	}

	public List<AvailabilitySlot> getAllSlots() {
		return slotRepo.findAll();
	}

}
