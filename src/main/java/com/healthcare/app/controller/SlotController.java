package com.healthcare.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.app.dto.SlotRequest;
import com.healthcare.app.entity.AvailabilitySlot;
import com.healthcare.app.service.SlotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
public class SlotController {
	private final SlotService slotService;
	@PostMapping
    public AvailabilitySlot createSlot(@RequestBody SlotRequest request) {
        return slotService.createSlot(
                request.getDoctorId(),
                request.getStartTime(),
                request.getEndTime()
        );
    }

    @GetMapping
    public List<AvailabilitySlot> getSlots() {
        return slotService.getAllSlots();
    }

}
