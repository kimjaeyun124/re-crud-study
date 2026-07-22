package com.example.crudresutdy.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCommentRequest(
        @NotBlank(message = "내용은 필수 입력사항 입니다.")
        String content
) { }
