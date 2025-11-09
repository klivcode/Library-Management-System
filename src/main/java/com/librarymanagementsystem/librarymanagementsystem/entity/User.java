package com.librarymanagementsystem.librarymanagementsystem.entity;


import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",length = 11,nullable = false)
    private Integer userId;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "email",length = 50,nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Borrow> borrows;


    public User(Integer userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
