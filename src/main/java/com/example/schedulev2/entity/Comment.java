package com.example.schedulev2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String comment;

    @Column(nullable = false)
    @NotNull
    private String writerId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    // 생성자
    public Comment(String comment, String writerId, Schedule schedule) {
        this.comment = comment;
        this.writerId = writerId;
        this.schedule = schedule;
    }

    // 업데이트 메서드
    public void update(String newComment) {
        this.comment = newComment;
    }

}
