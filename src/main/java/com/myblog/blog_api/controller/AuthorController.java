package com.myblog.blog_api.controller;

import com.myblog.blog_api.model.Author;
import com.myblog.blog_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        // 1. The request comes in and this method is triggered.
        // 2. The controller immediately calls the getAllAuthors() method in the AuthorService.
        // 3. The service then calls the repository, which gets the data from the database.
        // 4. The service returns the list of authors back to this controller.
        // 5. The controller returns the list. Spring Boot automatically converts it to JSON
        //    and sends it as the HTTP response with a default 200 OK status.
        return authorService.getAllAuthors();

    }
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        // 1. The request comes in. @RequestBody tells Spring to take the JSON from the request's body
        //    and automatically create an 'Author' Java object from it.

        // 2. The controller calls the createAuthor() method in the AuthorService,
        //    passing along the 'author' object it just received.
       Author createdAuthor = authorService.createAuthor(author);
        // 3. The service does its work (calls the repository) and returns the saved author,
        //    which now has an ID. We store it in the 'createdAuthor' variable.

        // 4. The controller's final job is to build the HTTP response. We create a ResponseEntity
        //    to have full control. We include the 'createdAuthor' object in the body
        //    and set the status to 201 CREATED, which is the correct standard for this operation.
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);

    }



}
