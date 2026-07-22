package com.example.crudresutdy.domain.comment.entity;

import com.example.crudresutdy.domain.post.entity.Post;
import com.example.crudresutdy.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comments")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Post postId;

    @Builder
    public Comment(String content, Post postId) {
        this.content = content;
        this.postId = postId;
    }

    public void update(String content) {
        this.content = content;
    }
}
