package com.example.schedulev2.dto.replyDto;

import lombok.Getter;

@Getter
public class ReplyRequestDto {

    private String reply;
    private String writerId;

    public ReplyRequestDto(String reply, String writerId) {
        this.reply = reply;
        this.writerId = writerId;
    }
}
