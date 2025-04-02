package com.example.scheduledevelop.dto.responseDto;

import com.example.scheduledevelop.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private Long scheduleId;

    private Long id;

    private String contents;

    public CommentResponseDto(Comment comment) {
        this.scheduleId = comment.getSchedule().getId();
        this.id = comment.getId();
        this.contents = comment.getContents();
    }
}
