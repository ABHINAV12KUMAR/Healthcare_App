package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entity.Appointment;

import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {

    List <Appointment>searchBypatientId(String patientId);
}
