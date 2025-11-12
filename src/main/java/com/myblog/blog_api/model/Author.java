package com.myblog.blog_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* @Entity:  told JPA to create a table named author in the blog_api_db database.
@Id & @GeneratedValue:  told JPA that the id column is the primary key and the database should handle creating its value.
@Data: used Lombok to generate getId(), setId()-, getName(), setName(), getEmail(), setEmail(), and several other useful methods without writing a single line of boilerplate.
@NoArgsConstructor & @AllArgsConstructor: used Lombok to generate the two constructors we need, one for JPA and one for our own convenience.

 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

}
