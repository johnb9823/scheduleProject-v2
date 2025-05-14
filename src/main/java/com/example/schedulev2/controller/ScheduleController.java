package com.example.schedulev2.controller;

import com.example.schedulev2.common.CommonResponse;
import com.example.schedulev2.common.StatusCode;
import com.example.schedulev2.dto.scheduleDto.ScheduleRequestDto;
import com.example.schedulev2.dto.scheduleDto.ScheduleResponseDto;
import com.example.schedulev2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> create(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto response = scheduleService.createSchedule(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<ScheduleResponseDto>>> getAll() {
        List<ScheduleResponseDto> responses = scheduleService.getAllSchedules();
        return ResponseEntity.ok(CommonResponse.success(responses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> getOne(@PathVariable Long id) {
        ScheduleResponseDto response = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(CommonResponse.success(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<ScheduleResponseDto>> update(@PathVariable Long id,
                                                                      @RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto response = scheduleService.updateSchedule(id, requestDto);
        return ResponseEntity.ok(CommonResponse.success(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Void>> delete(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok(CommonResponse.of(StatusCode.SUCCESS, null));
    }

}


