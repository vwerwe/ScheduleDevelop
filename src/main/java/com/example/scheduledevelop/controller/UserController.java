package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.requestDto.UserRequestDto;
import com.example.scheduledevelop.dto.responseDto.UserResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 생성
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.save(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /**
     * 유저 전체 조회
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {

        List<UserResponseDto> userResponseDtoList = userService.findAll();

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    /**
     * 유저 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 유저 이름 수정
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUsername(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.updateUsername(id, requestDto.getUsername(), requestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
