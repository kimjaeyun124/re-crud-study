package com.example.crudresutdy.domain.comment.service;

import com.example.crudresutdy.domain.comment.dto.request.CreateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.request.UpdateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.response.ReadCommentResponse;

import java.util.List;

public interface CommentService {
    ReadCommentResponse createComment(Long postId, CreateCommentRequest request);
    List<ReadCommentResponse> getPostComments(Long postId);
    ReadCommentResponse getComment(Long id);
    List<ReadCommentResponse> getAllComments();
    ReadCommentResponse updateComment(Long id, UpdateCommentRequest request);
    void deleteComment(Long id);
}
