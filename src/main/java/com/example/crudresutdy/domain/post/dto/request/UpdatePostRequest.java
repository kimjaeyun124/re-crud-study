package com.example.crudresutdy.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePostRequest(
        @NotBlank(message = "제목은 필수 입력사항 입니다.")
        @Size(max = 500, message = "제목의 최대 길이는 500자 입니다.")
        String title,

        @NotBlank(message = "내용은 필수 입력사항 입니다.")
        String content
) { }
