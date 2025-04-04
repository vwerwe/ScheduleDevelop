package com.example.scheduledevelop.dto.responseDto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long id;

    private String title;

    private String contents;

    public ScheduleResponseDto (Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
    }


}
