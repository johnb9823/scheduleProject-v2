package com.example.schedulev2.dto.scheduleDto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String title;
    private String content;
    private String writerId;

    public ScheduleRequestDto(String title, String content, String writerId) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }

}
