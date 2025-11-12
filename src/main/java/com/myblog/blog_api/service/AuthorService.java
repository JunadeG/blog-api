package com.myblog.blog_api.service;


import com.myblog.blog_api.model.Author;
import com.myblog.blog_api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this tells spring "this is a service bean" it marks the class.
public class AuthorService {

    @Autowired // this tells spring i need an instance of the author repository , please create one or find an existing one

    private AuthorRepository authorRepository;


    public Author createAuthor (Author author){
        return authorRepository.save(author);
        // this method basically delegates the task of saving the data to the repo layer. the repo ten handles all the SQl and database.
    }

    public List<Author> getAllAuthors(){
        //the service delegate the task of finding all authors to the repo.
        //the repo will then execute a "SELECT * FROM author" query behind the scenes

        return authorRepository.findAll();
    }


}
