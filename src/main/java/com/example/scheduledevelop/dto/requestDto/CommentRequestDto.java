package com.example.scheduledevelop.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @NotNull(message = "내용은 필수 입력값 입니다.")
    private String contents;

}
