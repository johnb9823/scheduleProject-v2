package com.example.schedulev2.service;

import com.example.schedulev2.dto.commentDto.CommentRequestDto;
import com.example.schedulev2.dto.commentDto.CommentResponseDto;
import com.example.schedulev2.entity.Comment;
import com.example.schedulev2.entity.Schedule;
import com.example.schedulev2.repository.CommentRepository;
import com.example.schedulev2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        Comment comment = new Comment(dto.getComment(), dto.getWriterId(), schedule);
        Comment saved = commentRepository.save(comment);
        return toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> getCommentsBySchedule(Long scheduleId) {
        return commentRepository.findAll().stream()
                .filter(c -> c.getSchedule().getId().equals(scheduleId))
                .sorted((a, b) -> a.getCreatedAt().compareTo(b.getCreatedAt()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentRequestDto dto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        comment.update(dto.getComment());
        return toDto(comment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }

    private CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getComment(),
                comment.getWriterId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                comment.getSchedule().getId()
        );
    }
}
