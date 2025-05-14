package com.example.schedulev2.repository;

import com.example.schedulev2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByScheduleId(Long scheduleId); // 스케줄 ID로 댓글 수 조회
}

