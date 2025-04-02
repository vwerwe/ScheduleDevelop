package com.example.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @Size(min = 2, message = "이름은 최소 2글자 이상이어야 합니다")
    @NotBlank(message = "이름은 필수 입력값 입니다.")
    private String username;

    @Size(min = 4, message = "비밀번호는 4글자 이상이어야 합니다.")
    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    private String password;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "올바른 이메일 형식이 아닙니다.")
    private String email;



}
