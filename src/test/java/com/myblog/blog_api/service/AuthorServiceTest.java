package com.myblog.blog_api.service;

import com.myblog.blog_api.model.Author;
import com.myblog.blog_api.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
     public void testGetAllAuthors(){
        Author a1 = new Author();
        a1.setId(1L);
        a1.setEmail("eff@example.com");
        a1.setName("Jeff");
        List<Author> fakeAuthors = List.of(a1);

        when(authorRepository.findAll()).thenReturn(fakeAuthors);
        List<Author> result = authorService.getAllAuthors();

        assertEquals(1, result.size());

     }

     @Test
     void testCreateAuthor(){
       Author authorToSave = new Author();
       authorToSave.setName("Jane");
       authorToSave.setId(1L);
       authorToSave.setEmail("jane@example.come");


      Author authorThatWasSaved = new Author();
      authorThatWasSaved.setId(1L);
      authorThatWasSaved.setName("Jane");
      authorThatWasSaved.setEmail("jane@example.com");

         when(authorRepository.save(any(Author.class))).thenReturn(authorThatWasSaved);
         Author result = authorService.createAuthor(authorToSave);
         assertNotNull(result);
         assertEquals(1L, result.getId());
         assertEquals("Jane", result.getName());
     }


}