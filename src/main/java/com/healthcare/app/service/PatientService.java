package com.healthcare.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare.app.entity.Patient;
import com.healthcare.app.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    // Create patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
