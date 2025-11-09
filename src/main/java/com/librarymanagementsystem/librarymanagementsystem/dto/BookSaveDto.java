package com.librarymanagementsystem.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSaveDto {

    private String title;
    private Integer authorId;
    private Integer publisherId;
}
