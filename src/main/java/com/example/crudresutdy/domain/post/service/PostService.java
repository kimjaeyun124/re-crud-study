package com.example.crudresutdy.domain.post.service;

import com.example.crudresutdy.domain.post.dto.request.CreatePostRequest;
import com.example.crudresutdy.domain.post.dto.request.UpdatePostRequest;
import com.example.crudresutdy.domain.post.dto.response.ReadPostResponse;

import java.util.List;

public interface PostService {
    ReadPostResponse createPost(CreatePostRequest request);
    ReadPostResponse getPost(Long id);
    List<ReadPostResponse> getAllPosts();
    ReadPostResponse updatePost(Long id, UpdatePostRequest request);
    void deletePost(Long id);
}
