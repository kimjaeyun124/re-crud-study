package com.example.crudresutdy.global.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ResponseKind {
    POST_ERROR(HttpStatus.NOT_FOUND, "게시물 오류"),
    COMMENT_ERROR(HttpStatus.NOT_FOUND, "댓글 오류"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "입력값 오류"),

    POST_POST(HttpStatus.CREATED, "게시물이 되었습니다."),
    POST_GET(HttpStatus.OK, "게시물이 조회 되었습니다."),
    POST_UPDATE(HttpStatus.CREATED, "게시물이 수정되었습니다."),
    POST_DELETE(HttpStatus.NO_CONTENT, "게시물이 삭제 되었습니다"),

    COMMENT_POST(HttpStatus.CREATED, "댓글이 되었습니다."),
    COMMENT_GET(HttpStatus.OK, "댓글이 조회 되었습니다."),
    COMMENT_UPDATE(HttpStatus.CREATED, "댓글이 수정되었습니다."),
    COMMENT_DELETE(HttpStatus.NO_CONTENT, "댓글이 삭제 되었습니다");

    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;
}
