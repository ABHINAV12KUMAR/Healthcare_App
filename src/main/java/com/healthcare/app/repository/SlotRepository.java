package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entity.AvailabilitySlot;

public interface SlotRepository extends JpaRepository<AvailabilitySlot,Long>  {

}
