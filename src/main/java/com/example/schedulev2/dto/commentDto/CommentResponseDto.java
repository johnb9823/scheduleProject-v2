package com.example.schedulev2.dto.commentDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponseDto {

    private String comment;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long scheduleId;

    public CommentResponseDto(String comment, String writerId, LocalDateTime createdAt, LocalDateTime updatedAt, Long scheduleId) {
        this.comment = comment;
        this.writerId = writerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.scheduleId = scheduleId;
    }

}
