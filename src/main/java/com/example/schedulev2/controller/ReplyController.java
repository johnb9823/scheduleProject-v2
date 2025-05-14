package com.example.schedulev2.controller;

import com.example.schedulev2.dto.replyDto.ReplyRequestDto;
import com.example.schedulev2.dto.replyDto.ReplyResponseDto;
import com.example.schedulev2.service.ReplyService;
import com.example.schedulev2.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments/{commentId}/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    // 대댓글 작성
    @PostMapping
    public ResponseEntity<CommonResponse<ReplyResponseDto>> createReply(
            @PathVariable Long scheduleId,
            @RequestBody ReplyRequestDto replyRequestDto
    ) {
        ReplyResponseDto replyResponseDto = replyService.createReply(scheduleId, replyRequestDto);
        return ResponseEntity.ok(CommonResponse.success(replyResponseDto));
    }

    // 대댓글 수정
    @PutMapping("/{replyId}")
    public ResponseEntity<CommonResponse<ReplyResponseDto>> updateReply(
            @PathVariable Long replyId,
            @RequestBody String newContent
    ) {
        ReplyResponseDto updatedReply = replyService.updateReply(replyId, newContent);
        return ResponseEntity.ok(CommonResponse.success(updatedReply));
    }

    // 대댓글 삭제
    @DeleteMapping("/{replyId}")
    public ResponseEntity<CommonResponse<Void>> deleteReply(@PathVariable Long replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.ok(CommonResponse.success(null));
    }
}

