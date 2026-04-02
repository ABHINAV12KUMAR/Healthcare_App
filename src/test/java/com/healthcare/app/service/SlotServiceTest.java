/*
package com.healthcare.app.service;


import com.healthcare.app.entity.AvailabilitySlot;
import com.healthcare.app.entity.Doctor;
import com.healthcare.app.entity.SlotStatus;
import com.healthcare.app.repository.DoctorRepository;
import com.healthcare.app.repository.SlotRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SlotServiceTest {

        @Test
        void testCreateSlot() {

            // Mock repositories
            SlotRepository slotRepo = mock(SlotRepository.class);
            DoctorRepository doctorRepo = mock(DoctorRepository.class);

            // Service
            SlotService service = new SlotService(slotRepo, doctorRepo);

            // Test data
            Doctor doctor = new Doctor();
            doctor.setId(1L);

            LocalDateTime start = LocalDateTime.now();
            LocalDateTime end = start.plusHours(1);

            // Mock behavior
            when(doctorRepo.findById(1L)).thenReturn(Optional.of(doctor));
            when(slotRepo.save(any(AvailabilitySlot.class)))
                    .thenAnswer(invocation -> invocation.getArgument(0));

            // Call method
            AvailabilitySlot result = service.createSlot(1L, start, end);

            // Assertions
            assertNotNull(result);
            assertEquals(doctor, result.getDoctor());
            assertEquals(start, result.getStartTime());
            assertEquals(end, result.getEndTime());
            assertEquals(SlotStatus.ACTIVE, result.getStatus());

            // Verify
            verify(doctorRepo).findById(1L);
            verify(slotRepo).save(any(AvailabilitySlot.class));
        }

        @Test
        void testCreateSlot_DoctorNotFound() {

            SlotRepository slotRepo = mock(SlotRepository.class);
            DoctorRepository doctorRepo = mock(DoctorRepository.class);

            SlotService service = new SlotService(slotRepo, doctorRepo);

            when(doctorRepo.findById(1L)).thenReturn(Optional.empty());

            assertThrows(RuntimeException.class, () -> {
                service.createSlot(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            });
        }

        @Test
        void testGetAllSlots() {

            SlotRepository slotRepo = mock(SlotRepository.class);
            DoctorRepository doctorRepo = mock(DoctorRepository.class);

            SlotService service = new SlotService(slotRepo, doctorRepo);

            AvailabilitySlot slot1 = new AvailabilitySlot();
            AvailabilitySlot slot2 = new AvailabilitySlot();

            when(slotRepo.findAll()).thenReturn(Arrays.asList(slot1, slot2));

            List<AvailabilitySlot> result = service.getAllSlots();

            assertEquals(2, result.size());
            verify(slotRepo).findAll();
        }
    }
*/
