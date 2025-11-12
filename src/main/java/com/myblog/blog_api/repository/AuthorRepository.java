package com.myblog.blog_api.repository;

import com.myblog.blog_api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
