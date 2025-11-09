package com.librarymanagementsystem.librarymanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublisherUpdateDto
{
    private Integer publisherId;
    private String name;
}
