package com.example.schedulev2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String content;

    @Column(nullable = false)
    @NotNull
    private String writerId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment; //부모 댓글 id

    // 생성자
    public Reply(String content, String writerId, Schedule schedule, Comment comment) {
        this.content = content;
        this.writerId = writerId;
        this.schedule = schedule;
        this.comment = comment;
    }

    // 업데이트 메서드
    public void update(String newContent) {
        this.content = newContent;
    }
}
