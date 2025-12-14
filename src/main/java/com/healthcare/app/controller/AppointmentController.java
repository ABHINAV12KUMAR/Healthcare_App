package com.healthcare.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.app.entity.Appointment;
import com.healthcare.app.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {
	private final AppointmentService appointmentService;

    @PostMapping
    public Appointment book(
            @RequestParam Long slotId,
            @RequestParam Long patientId) {
        return appointmentService.bookAppointment(slotId, patientId);
    }
}
