package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.PageResponseDto;
import com.example.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ScheduleService {

    ScheduleResponseDto save(String username, String title, String contents);

//    Page<ScheduleResponseDto> findAll(Pageable pageable);

    ScheduleResponseDto findById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String title, String contents);

    void delete(Long id);

    Page<PageResponseDto> findPageBySchedule(Pageable pageable);
}
