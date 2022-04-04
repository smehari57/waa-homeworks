package com.starproject.waa.homeworks.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String author;
}
