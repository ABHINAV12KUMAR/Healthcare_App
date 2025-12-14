package com.healthcare.app.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SlotRequest {
	private Long doctorId;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime;
}
