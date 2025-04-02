package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.CommentResponseDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface CommentService {
    CommentResponseDto save(Long scheduleId, String contents);

    List<CommentResponseDto> findAll(Long scheduleId);
}
