package com.xworkz.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie_details")
public class MovieDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "language")
    private String language;
    @Column(name = "cast")
    private Double cast;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "rating")
    private Double rating;

    public MovieDetailsEntity(String title, String genre, String language, Double cast, Integer duration, Double rating) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.cast = cast;
        this.duration = duration;
        this.rating = rating;
    }
}
