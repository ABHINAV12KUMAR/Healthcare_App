package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>  {

}
