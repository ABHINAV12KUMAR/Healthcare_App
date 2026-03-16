package com.healthcare.app;

import com.healthcare.app.entity.Appointment;
import com.healthcare.app.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthcareApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void searchBypatientId() {
		Appointment employee = AppointmentRepository.searchByEmail("sam@gmail.com");

		System.out.println(Appointment.getId());
		System.out.println(Appointment.getName());
		System.out.println(Appointment.getEmailId());
		System.out.println(Appointment.getMobile());
	}

}
