package com.librarymanagementsystem.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id",length = 11,nullable = false)
    private Integer publisherId;

    @Column(name = "name",length = 40,nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private Set<Book> books;


    public Publisher(String name, Integer publisherId) {
        this.name = name;
        this.publisherId = publisherId;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
