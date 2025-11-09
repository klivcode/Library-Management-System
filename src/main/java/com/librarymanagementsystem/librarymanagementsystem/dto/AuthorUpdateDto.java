package com.librarymanagementsystem.librarymanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateDto {

    private  Integer authorId;
    private String name;
}
