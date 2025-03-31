package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto save(String username, String title, String contents);


    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String title, String contents);

    void delete(Long id);
}
