package com.example.crudresutdy.domain.post.controller;

import com.example.crudresutdy.domain.post.dto.request.CreatePostRequest;
import com.example.crudresutdy.domain.post.dto.request.UpdatePostRequest;
import com.example.crudresutdy.domain.post.dto.response.ReadPostResponse;
import com.example.crudresutdy.domain.post.service.PostService;
import com.example.crudresutdy.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.crudresutdy.global.common.ResponseKind.*;

@RestController // @Controller + @ResponseBOdy + @Component
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReadPostResponse>> createPost(
            @Valid @RequestBody CreatePostRequest request
            ) {
        ReadPostResponse response = postService.createPost(request);
        return ResponseEntity.ok(
                ApiResponse.ok(POST_POST.getHttpStatus(), POST_POST.getMessage(), POST_POST, response)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReadPostResponse>>> readAllPost() {
        List<ReadPostResponse> response = postService.getAllPosts();
        return ResponseEntity.ok(ApiResponse.ok(POST_GET.getHttpStatus(), POST_GET.getMessage(), POST_GET, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReadPostResponse>> readPost(@PathVariable Long id) {
        ReadPostResponse response = postService.getPost(id);
        return ResponseEntity.ok(ApiResponse.ok(POST_GET.getHttpStatus(), POST_GET.getMessage(), POST_GET, response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ReadPostResponse>> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePostRequest request) {
        ReadPostResponse response = postService.updatePost(id, request);
        return ResponseEntity.ok(ApiResponse.ok(POST_UPDATE.getHttpStatus(), POST_UPDATE.getMessage(), POST_UPDATE, response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok(ApiResponse.ok(POST_DELETE.getHttpStatus(), POST_DELETE.getMessage(), POST_DELETE));
    }
}
