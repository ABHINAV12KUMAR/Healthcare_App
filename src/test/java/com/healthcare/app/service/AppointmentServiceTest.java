package com.healthcare.app.service;

import com.healthcare.app.entity.*;
import com.healthcare.app.repository.AppointmentRepository;
import com.healthcare.app.repository.PatientRepository;
import com.healthcare.app.repository.SlotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    AppointmentRepository appointmentRepository;
    @Mock
    private SlotRepository slotRepository;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    AppointmentService appointmentService;
    @Test
    void shouldBookAppointmentSuccessfully(){
    // Given
        Long slotId= 1L;
        Long patientId =10L;
        AvailabilitySlot slot=new AvailabilitySlot();
        slot.setStatus(SlotStatus.ACTIVE);
        slot.setDoctor(new Doctor());// dummy Object

        Patient patient = new Patient();
        Mockito.when(slotRepository.findById(slotId))
                .thenReturn(Optional.of(slot));
        Mockito.when(patientRepository.findById(patientId))
                .thenReturn(Optional.of(patient));

        Mockito.when(appointmentRepository.save(Mockito.any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Appointment result = appointmentService.bookAppointment(slotId,patientId);
        // Then
        assertNotNull(result);
        assertEquals(AppointmentStatus.CONFIRMED,result.getStatus());
        assertEquals(SlotStatus.BOOKED,slot.getStatus());

        Mockito.verify(slotRepository).findById(slotId);
        Mockito.verify(patientRepository).findById(patientId);
        Mockito.verify(appointmentRepository).save(Mockito.any());
    }
    // Edge Case
    @Test
    void shouldThrowExceptionSlotNotFound(){
        Mockito.when(slotRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,()->{
            appointmentService.bookAppointment(1L,10L);
        });
    }
    // Slot Already Booked
    @Test
    void shouldThrowExceptionWhenSlotNotActive() {
        AvailabilitySlot slot = new AvailabilitySlot();
        slot.setStatus(SlotStatus.BOOKED);

        Mockito.when(slotRepository.findById(1L))
                .thenReturn(Optional.of(slot));

        assertThrows(RuntimeException.class, () -> {
            appointmentService.bookAppointment(1L, 10L);
        });
    }
    @Test
    void shouldThrowExceptionWhenPatientNotFound() {

        AvailabilitySlot slot = new AvailabilitySlot();
        slot.setStatus(SlotStatus.ACTIVE);

        Mockito.when(slotRepository.findById(1L))
                .thenReturn(Optional.of(slot));

        Mockito.when(patientRepository.findById(10L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            appointmentService.bookAppointment(1L, 10L);
        });
    }

}