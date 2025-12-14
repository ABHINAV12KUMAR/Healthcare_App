package com.healthcare.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne
    @JoinColumn(name = "slot_id")
	private AvailabilitySlot slot;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

}
