package com.example.schedulev2.entity;

import com.example.schedulev2.dto.scheduleDto.ScheduleRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA에서 필요
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(nullable = false)
    @NotNull
    private String content;

    @Column(nullable = false)
    @NotNull
    private String writerId;

    // 생성자
    public Schedule(String title, String content, String writerId) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }

    public Schedule(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writerId = requestDto.getWriterId();
    }

    // 업데이트
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
