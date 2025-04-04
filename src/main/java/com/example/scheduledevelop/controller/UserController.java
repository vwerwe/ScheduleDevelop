package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.requestDto.UserCheckPasswordRequest;
import com.example.scheduledevelop.dto.requestDto.UserLoginRequestDto;
import com.example.scheduledevelop.dto.requestDto.UserNameUpdateRequestDto;
import com.example.scheduledevelop.dto.requestDto.UserRequestDto;
import com.example.scheduledevelop.dto.responseDto.UserResponseDto;
import com.example.scheduledevelop.loginConst.Const;
import com.example.scheduledevelop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 생성(회원가입)
     */
    @PostMapping("signup")
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.save(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /** 로그인 기능 */
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginRequestDto requestDto, HttpServletRequest request) {

        UserResponseDto loginUser = userService.login(requestDto.getEmail(), requestDto.getPassword());

        HttpSession session = request.getSession();

        session.setAttribute(Const.LOGIN_USER, loginUser);

        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
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
    public ResponseEntity<UserResponseDto> updateUsername(@PathVariable Long id, @Valid @RequestBody UserNameUpdateRequestDto requestDto) {

        UserResponseDto userResponseDto = userService.updateUsername(id, requestDto.getUsername(), requestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /** 유저 삭제 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestBody UserCheckPasswordRequest requestDto) {

        userService.delete(id, requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
