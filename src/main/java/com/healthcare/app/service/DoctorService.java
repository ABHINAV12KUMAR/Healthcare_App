package com.healthcare.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare.app.entity.Doctor;
import com.healthcare.app.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DoctorService {
	private final DoctorRepository doctorRepo;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

}
