package com.example.crudresutdy.domain.comment.controller;

import com.example.crudresutdy.domain.comment.dto.request.CreateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.request.UpdateCommentRequest;
import com.example.crudresutdy.domain.comment.dto.response.ReadCommentResponse;
import com.example.crudresutdy.domain.comment.service.CommentService;
import com.example.crudresutdy.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.crudresutdy.global.common.ResponseKind.*;

@RestController // @Controller + @ResponseBOdy + @Component
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{postId}/comments")
    public ResponseEntity<ApiResponse<ReadCommentResponse>> createComment(
            @PathVariable Long postId,
            @Valid @RequestBody CreateCommentRequest request
            ) {
        ReadCommentResponse response = commentService.createComment(postId, request);
        return ResponseEntity
                .status(COMMENT_POST.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_POST.getHttpStatus(), COMMENT_POST.getMessage(), COMMENT_POST, response));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<ApiResponse<List<ReadCommentResponse>>> readPostComment(@PathVariable Long postId) {
        List<ReadCommentResponse> response = commentService.getPostComment(postId);
        return ResponseEntity
                .status(COMMENT_GET.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_GET.getHttpStatus(), COMMENT_GET.getMessage(), COMMENT_GET, response));
    }

    @GetMapping("comments/{id}")
    public ResponseEntity<ApiResponse<ReadCommentResponse>> readComment(@PathVariable Long id) {
        ReadCommentResponse response = commentService.getComment(id);
        return ResponseEntity
                .status(COMMENT_GET.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_GET.getHttpStatus(), COMMENT_GET.getMessage(), COMMENT_GET, response));
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse<List<ReadCommentResponse>>> readAllComment() {
        List<ReadCommentResponse> response = commentService.getAllComments();
        return ResponseEntity
                .status(COMMENT_GET.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_GET.getHttpStatus(), COMMENT_GET.getMessage(), COMMENT_GET, response));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<ApiResponse<ReadCommentResponse>> updateComment(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCommentRequest request) {
        ReadCommentResponse response = commentService.updateComment(id, request);
        return ResponseEntity
                .status(COMMENT_UPDATE.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_UPDATE.getHttpStatus(), COMMENT_UPDATE.getMessage(), COMMENT_UPDATE, response));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity
                .status(COMMENT_DELETE.getHttpStatus())
                .body(ApiResponse.ok(COMMENT_DELETE.getHttpStatus(), COMMENT_DELETE.getMessage(), COMMENT_DELETE));
    }
}
