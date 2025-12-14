package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
