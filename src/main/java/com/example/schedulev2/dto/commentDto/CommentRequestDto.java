package com.example.schedulev2.dto.commentDto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private String comment;
    private String writerId;

    public CommentRequestDto(String comment, String writerId) {
        this.comment = comment;
        this.writerId = writerId;
    }

}
