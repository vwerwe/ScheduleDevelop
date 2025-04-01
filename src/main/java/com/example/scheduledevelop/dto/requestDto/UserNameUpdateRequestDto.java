package com.example.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserNameUpdateRequestDto {

    @Size(min = 2, message = "이름은 최소 2글자 이상이어야 합니다")
    @NotBlank(message = "이름은 필수 입력값 입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    private String password;

}
