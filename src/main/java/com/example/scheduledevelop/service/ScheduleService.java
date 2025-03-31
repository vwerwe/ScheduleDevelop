package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.ScheduleResponseDto;

public interface ScheduleService {

    ScheduleResponseDto save(String username, String title, String contents);




}
