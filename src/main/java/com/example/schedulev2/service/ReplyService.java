package com.example.schedulev2.service;

import com.example.schedulev2.dto.replyDto.ReplyRequestDto;
import com.example.schedulev2.dto.replyDto.ReplyResponseDto;
import com.example.schedulev2.entity.Comment;
import com.example.schedulev2.entity.Reply;
import com.example.schedulev2.entity.Schedule;
import com.example.schedulev2.repository.CommentRepository;
import com.example.schedulev2.repository.ReplyRepository;
import com.example.schedulev2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    // 대댓글 작성
    @Transactional
    public ReplyResponseDto createReply(Long scheduleId, ReplyRequestDto replyRequestDto) {
        // 일정과 댓글 확인
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("일정을 찾을 수 없습니다."));
        Comment parentComment = commentRepository.findById(replyRequestDto.getCommentId())
                .orElseThrow(() -> new RuntimeException("부모 댓글을 찾을 수 없습니다."));

        // 대댓글 생성
        Reply reply = new Reply(replyRequestDto.getContent(), replyRequestDto.getWriterId(), schedule, parentComment);
        replyRepository.save(reply);

        // 대댓글 반환
        return new ReplyResponseDto(reply.getContent(), reply.getWriterId(), reply.getCreatedAt(), reply.getUpdatedAt());
    }

    // 대댓글 수정
    @Transactional
    public ReplyResponseDto updateReply(Long replyId, String newContent) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("대댓글을 찾을 수 없습니다."));
        reply.update(newContent);

        return new ReplyResponseDto(reply.getContent(), reply.getWriterId(), reply.getCreatedAt(), reply.getUpdatedAt());
    }

    // 대댓글 삭제
    @Transactional
    public void deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new RuntimeException("대댓글을 찾을 수 없습니다."));
        replyRepository.delete(reply);
    }
}

