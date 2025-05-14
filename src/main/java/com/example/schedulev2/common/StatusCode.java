package com.example.schedulev2.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum StatusCode {

    SUCCESS(HttpStatus.OK, 200, "요청에 성공했습니다."),
    CREATED(HttpStatus.CREATED,201, "생성에 성공했습니다."),
    UPDATED(HttpStatus.OK, 200, "수정에 성공했습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,400, "필수 항목이 누락 되었습니다."),
    DELETE_FAIL(HttpStatus.FORBIDDEN, 403,"삭제 권한이 없습니다."),
    UPDATE_FAIL(HttpStatus.FORBIDDEN, 403,"수정 권한이 없습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, 404,"요청한 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,500, "서버 오류입니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    StatusCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
