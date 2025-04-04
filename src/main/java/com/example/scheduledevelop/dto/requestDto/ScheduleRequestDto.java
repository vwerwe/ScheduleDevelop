package com.example.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @Size(min = 2, message = "이름은 최소 2글자 이상이어야 합니다")
    @NotBlank(message = "이름은 필수 입력값 입니다.")
    private String username;

    @Size(max = 10, message = "제목의 최대길이는 10글자 입니다.")
    @NotNull(message = "제목은 필수 입력값 입니다.")
    private String title;

    @NotNull(message = "내용은 필수 입력값 입니다.")
    private String contents;

}
