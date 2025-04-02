package com.example.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserCheckPasswordRequest {

    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    private String password;

}
