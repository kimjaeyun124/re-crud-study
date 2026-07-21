package com.example.crudresutdy.domain.post.dto.response;

import com.example.crudresutdy.domain.post.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

public record ReadPostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ReadPostResponse of(Post post) {
        return new ReadPostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public static List<ReadPostResponse> formList(List<Post> post) {
        return post.stream()
                .map(ReadPostResponse::of)
                .toList();
    }
}
