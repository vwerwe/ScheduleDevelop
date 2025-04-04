package com.example.scheduledevelop.dto.responseDto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PageResponseDto {

    private Long scheduleId;

    private String title;

    private String contents;

    private Long commentCnt;

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    private String username;


    public PageResponseDto(Long scheduleId, String title, String contents, Long commentCnt, LocalDateTime createAt, LocalDateTime modifiedAt, String username) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.contents = contents;
        this.commentCnt = commentCnt;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.username = username;
    }
}
