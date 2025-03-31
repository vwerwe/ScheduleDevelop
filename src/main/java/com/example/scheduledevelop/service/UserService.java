package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(String username, String email);

    List<UserResponseDto> findAll();

    UserResponseDto findById(Long id);
}
