package com.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class MovieDetailsDTO implements Serializable {
    private String title;
    private String genre;
    private String language;
    private Double cast;
    private Integer duration;
    private Double rating;
}
