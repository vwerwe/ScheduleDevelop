package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.requestDto.CommentRequestDto;
import com.example.scheduledevelop.dto.responseDto.CommentResponseDto;
import com.example.scheduledevelop.service.CommentService;
import jakarta.validation.Valid;
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

    /**
     * 댓글 작성
     */
    @PostMapping
    public ResponseEntity<CommentResponseDto> save(@PathVariable Long scheduleId, @Valid @RequestBody CommentRequestDto requestDto) {

        CommentResponseDto commentResponseDto = commentService.save(scheduleId, requestDto.getContents());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    /**
     * 특정 일정의 댓글 전체 조회
     */
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> findAll(@PathVariable Long scheduleId) {

        List<CommentResponseDto> CommentResponseDtoList = commentService.findAll(scheduleId);

        return new ResponseEntity<>(CommentResponseDtoList, HttpStatus.OK);
    }

    /**
     * 특정 일정의 댓글 개별 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id) {

        CommentResponseDto commentResponseDto = commentService.findById(id);

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    /**
     * 댓글 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long id, @Valid @RequestBody CommentRequestDto requestDto) {

        CommentResponseDto commentResponseDto = commentService.update(id, requestDto.getContents());

        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    /**
     * 댓글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {

        commentService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
