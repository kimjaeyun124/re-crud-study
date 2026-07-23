package com.example.crudresutdy.domain.comment.service.impl;

import com.example.crudresutdy.domain.comment.dto.request.CreateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.request.UpdateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.response.ReadCommentResponse;
import com.example.crudresutdy.domain.comment.entity.Comment;
import com.example.crudresutdy.domain.comment.repository.CommentRepository;
import com.example.crudresutdy.domain.comment.service.CommentService;
import com.example.crudresutdy.domain.post.entity.Post;
import com.example.crudresutdy.domain.post.repository.PostRepository;
import com.example.crudresutdy.global.exception.CommentException;
import com.example.crudresutdy.global.exception.ErrorCode;
import com.example.crudresutdy.global.exception.PostException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private Post getPostOrThrow(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.POST_NOT_FOUND));
    }

    private Comment getCommentOrThrow(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new CommentException(ErrorCode.COMMENT_NOT_FOUND));
    }

    @Transactional
    public ReadCommentResponse createComment(Long postId, CreateCommentRequest commentRequest) {
        Comment comment = Comment.builder()
                .content(commentRequest.content())
                .postId(getPostOrThrow(postId))
                .build();

        return ReadCommentResponse.of(commentRepository.save(comment));
    }

    public List<ReadCommentResponse> getPostComments(Long postId) {
        getPostOrThrow(postId);

        return ReadCommentResponse.formList(commentRepository.findByPostId(postId));
    }

    public ReadCommentResponse getComment(Long id) {
        return ReadCommentResponse.of(getCommentOrThrow(id));
    }

    public List<ReadCommentResponse> getAllComments() {
        return ReadCommentResponse.formList(commentRepository.findAll());
    }

    @Transactional
    public ReadCommentResponse updateComment(Long id, UpdateCommentRequest request) {
        Comment comment = getCommentOrThrow(id);
        comment.update(request.content());
        return ReadCommentResponse.of(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.delete(getCommentOrThrow(id));
    }
}
