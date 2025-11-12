package com.myblog.blog_api.service;


import com.myblog.blog_api.model.Author;
import com.myblog.blog_api.model.Post;
import com.myblog.blog_api.repository.AuthorRepository;
import com.myblog.blog_api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        //delegate the call directly to the post repo.
        return postRepository.findAll();

    }

    public Post createPost(Long authorId, Post post){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        post.setAuthor(author);

        // we use the author repo to find the author by their ID.
        //the findById method returns an optional<author>
        //if the optional is empty, it throws the exception we provided, which stops the method.
        //after that if it is found we need to link our found 'author', and we use the setter method that lombok generated for us
        //set.Author

        return postRepository.save(post);


    }
}
