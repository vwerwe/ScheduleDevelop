package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.requestDto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.requestDto.ScheduleUpdateRequestDto;
import com.example.scheduledevelop.dto.responseDto.PageResponseDto;
import com.example.scheduledevelop.dto.responseDto.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 일정 생성
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }


    /** 일정 정보 전체조회 페이징 */
    @GetMapping
    public ResponseEntity<Page<PageResponseDto>> findSchedule(@PageableDefault(size = 10) Pageable pageable) {

        Page<PageResponseDto> pageBySchedule = scheduleService.findPageBySchedule(pageable);

        return new ResponseEntity<>(pageBySchedule, HttpStatus.OK);
    }

    /** 일정 개별 조회 */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 전체 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleUpdateRequestDto requestDto
    ) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    /** 일정 삭제 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * 일정 전체 조회 페이징
     */
//    @GetMapping
//    public ResponseEntity<List<ScheduleResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
//
//        Page<ScheduleResponseDto> scheduleResponseDtoPage = scheduleService.findAll(pageable);
//
//        return new ResponseEntity<>(scheduleResponseDtoPage.getContent(), HttpStatus.OK);
//    }



}
