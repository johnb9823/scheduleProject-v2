package com.example.schedulev2.dto.replyDto;

import lombok.Getter;

@Getter
public class ReplyRequestDto {

    private String content;
    private String writerId;
    private Long commentId; // 부모 댓글 ID

    public ReplyRequestDto(String content, String writerId, Long commentId) {
        this.content = content;
        this.writerId = writerId;
        this.commentId = commentId;
    }
}
