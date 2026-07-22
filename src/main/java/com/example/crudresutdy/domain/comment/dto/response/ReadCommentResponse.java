package com.example.crudresutdy.domain.comment.dto.response;

import com.example.crudresutdy.domain.comment.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public record ReadCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ReadCommentResponse of(Comment post) {
        return new ReadCommentResponse(
                post.getId(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public static List<ReadCommentResponse> formList(List<Comment> post) {
        return post.stream()
                .map(ReadCommentResponse::of)
                .toList();
    }
}
