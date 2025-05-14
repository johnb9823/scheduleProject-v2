package com.example.schedulev2.controller;

import com.example.schedulev2.common.CommonResponse;
import com.example.schedulev2.common.StatusCode;
import com.example.schedulev2.dto.commentDto.CommentRequestDto;
import com.example.schedulev2.dto.commentDto.CommentResponseDto;
import com.example.schedulev2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommonResponse<CommentResponseDto>> createComment(@PathVariable Long scheduleId,
                                                                            @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.status(201)
                .body(CommonResponse.of(StatusCode.CREATED, commentService.createComment(scheduleId, requestDto)));
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<CommentResponseDto>>> getComments(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(CommonResponse.success(commentService.getCommentsBySchedule(scheduleId)));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommonResponse<CommentResponseDto>> updateComment(@PathVariable Long commentId,
                                                                            @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.ok(CommonResponse.of(StatusCode.UPDATED, commentService.updateComment(commentId, requestDto)));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommonResponse<?>> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(CommonResponse.of(StatusCode.SUCCESS));
    }
}

