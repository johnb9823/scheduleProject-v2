package com.example.schedulev2.dto.scheduleDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 필드는 JSON에서 제외됨
public class ScheduleResponseDto {

    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public ScheduleResponseDto(String title, String content, String writerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
