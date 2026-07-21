package com.example.crudresutdy.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ErrorCode {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "존재 하지않는 게시글입니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 댓글입니다.");

    @Getter
    private final HttpStatus status;

    @Getter
    private final String message;
}
