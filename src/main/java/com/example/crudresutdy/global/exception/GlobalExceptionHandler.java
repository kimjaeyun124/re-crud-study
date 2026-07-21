package com.example.crudresutdy.global.exception;

import com.example.crudresutdy.global.common.ApiResponse;
import com.example.crudresutdy.global.common.ResponseKind;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ApiResponse<Void>> handlePostException(
            PostException e
    ) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.fail(errorCode.getStatus(), errorCode.getMessage(), ResponseKind.POST_ERROR));
    }

    @ExceptionHandler(CommentException.class)
    public ResponseEntity<ApiResponse<Void>> handleCommentException(
            CommentException e
    ) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.fail(errorCode.getStatus(), errorCode.getMessage(), ResponseKind.COMMENT_ERROR));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(
            ValidationException e
    ) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.fail(errorCode.getStatus(), errorCode.getMessage(), ResponseKind.VALIDATION_ERROR));
    }
}
