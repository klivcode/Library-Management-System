package com.librarymanagementsystem.librarymanagementsystem.entity;


import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",length = 11,nullable = false)
    private Integer authorId;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;




    public Author(Integer authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
