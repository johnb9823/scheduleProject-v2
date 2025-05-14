package com.example.schedulev2.service;

import com.example.schedulev2.dto.scheduleDto.ScheduleRequestDto;
import com.example.schedulev2.dto.scheduleDto.ScheduleResponseDto;
import com.example.schedulev2.entity.Schedule;
import com.example.schedulev2.repository.CommentRepository;
import com.example.schedulev2.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 일정 생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        scheduleRepository.save(schedule);
        return toDto(schedule, 0L); // 생성 시 댓글 0개
    }

    // 전체 일정 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(schedule -> {
                    Long count = commentRepository.countByScheduleId(schedule.getId());
                    return toDto(schedule, count);
                })
                .collect(Collectors.toList());
    }

    // 단일 일정 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("일정이 존재하지 않습니다."));
        Long count = commentRepository.countByScheduleId(id);
        return toDto(schedule, count);
    }

    // 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("일정이 존재하지 않습니다."));
        schedule.update(requestDto.getTitle(), requestDto.getContent());
        Long count = commentRepository.countByScheduleId(id);
        return toDto(schedule, count);
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("일정이 존재하지 않습니다."));
        scheduleRepository.delete(schedule);
    }

    // Entity → Dto 변환
    private ScheduleResponseDto toDto(Schedule schedule, Long commentCount) {
        return new ScheduleResponseDto(
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getWriterId(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                commentCount
        );
    }
}


