package com.healthcare.app.service;

import org.springframework.stereotype.Service;

import com.healthcare.app.entity.Appointment;
import com.healthcare.app.entity.AppointmentStatus;
import com.healthcare.app.entity.AvailabilitySlot;
import com.healthcare.app.entity.Patient;
import com.healthcare.app.entity.SlotStatus;
import com.healthcare.app.repository.AppointmentRepository;
import com.healthcare.app.repository.PatientRepository;
import com.healthcare.app.repository.SlotRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {
	   private final AppointmentRepository appointmentRepo;
	   private final SlotRepository slotRepo;
	   private final PatientRepository patientRepo;
	   
	   public Appointment bookAppointment(Long slotId, Long patientId) {

		    AvailabilitySlot slot = slotRepo.findById(slotId)
		            .orElseThrow(() -> new RuntimeException("Slot not found"));

		    if (slot.getStatus() != SlotStatus.ACTIVE) {
		        throw new RuntimeException("Slot already booked");
		    }

		    Patient patient = patientRepo.findById(patientId)
		            .orElseThrow(() -> new RuntimeException("Patient not found"));

		    slot.setStatus(SlotStatus.BOOKED);

		    Appointment appointment = new Appointment();
		    appointment.setDoctor(slot.getDoctor());
		    appointment.setPatient(patient);
		    appointment.setSlot(slot);
		    appointment.setStatus(AppointmentStatus.CONFIRMED);

		    return appointmentRepo.save(appointment);
		}
}
