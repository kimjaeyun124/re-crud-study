package com.example.crudresutdy.domain.post.service.impl;

import com.example.crudresutdy.domain.post.dto.request.CreatePostRequest;
import com.example.crudresutdy.domain.post.dto.request.UpdatePostRequest;
import com.example.crudresutdy.domain.post.dto.response.ReadPostResponse;
import com.example.crudresutdy.domain.post.entity.Post;
import com.example.crudresutdy.domain.post.repository.PostRepository;
import com.example.crudresutdy.domain.post.service.PostService;
import com.example.crudresutdy.global.exception.ErrorCode;
import com.example.crudresutdy.global.exception.PostException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService  {
    private final PostRepository postRepository;

    @Transactional
    public ReadPostResponse createPost(CreatePostRequest postRequest) {
        Post post = Post.builder()
                .title(postRequest.title())
                .content(postRequest.content())
                .build();
        return ReadPostResponse.of(postRepository.save(post));
    }

    public ReadPostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.POST_NOT_FOUND));

        return ReadPostResponse.of(post);
    }

    public List<ReadPostResponse> getAllPosts() {
        return ReadPostResponse.formList(postRepository.findAll());
    }

    @Transactional
    public ReadPostResponse updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.POST_NOT_FOUND));
        post.updatePost(request.title(), request.content());
        return ReadPostResponse.of(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.POST_NOT_FOUND));
        postRepository.delete(post);
    }
}
