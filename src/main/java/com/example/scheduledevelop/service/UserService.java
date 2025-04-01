package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserResponseDto save(String username, String password, String email);

    List<UserResponseDto> findAll();

    UserResponseDto findById(Long id);

    UserResponseDto updateUsername(Long id, String username, String password);

    void delete(Long id);

    UserResponseDto login(String email, String password);
}
