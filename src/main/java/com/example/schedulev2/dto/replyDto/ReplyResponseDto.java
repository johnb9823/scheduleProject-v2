package com.example.schedulev2.dto.replyDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplyResponseDto {

    private String reply;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ReplyResponseDto(String reply, String writerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.reply = reply;
        this.writerId = writerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
