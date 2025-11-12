package com.myblog.blog_api.controller;

import com.myblog.blog_api.model.Post;
import com.myblog.blog_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {


    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        // The controller's job is simple: call the service and return the result.
        return postService.getAllPosts();
    }
    @PostMapping("/authors/{authorId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable Long authorId , @RequestBody Post post){
        Post savedPost = postService.createPost(authorId, post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);

    }

}
