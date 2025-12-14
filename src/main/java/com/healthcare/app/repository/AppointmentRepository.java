package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entity.Appointment;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {

}
