package com.example.schedulev2.dto.replyDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyResponseDto {

    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReplyResponseDto(String content, String writerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.content = content;
        this.writerId = writerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
