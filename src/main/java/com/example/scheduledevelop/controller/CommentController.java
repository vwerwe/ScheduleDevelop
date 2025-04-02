package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.requestDto.CommentRequestDto;
import com.example.scheduledevelop.dto.responseDto.CommentResponseDto;
import com.example.scheduledevelop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> save(@PathVariable Long scheduleId, @RequestBody CommentRequestDto requestDto) {

        CommentResponseDto commentResponseDto = commentService.save(scheduleId, requestDto.getContents());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> findAll(@PathVariable Long scheduleId) {

        List<CommentResponseDto> CommentResponseDtoList = commentService.findAll(scheduleId);

        return new ResponseEntity<>(CommentResponseDtoList, HttpStatus.OK);
    }


}
