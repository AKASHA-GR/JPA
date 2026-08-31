package com.xworkz.service;

import com.xworkz.dto.MovieDetailsDTO;

import java.util.List;

public interface MovieDetailService {
    public String validateAndSave(MovieDetailsDTO movieDetailsDTO);

    public String validateAndSave(List<MovieDetailsDTO> movieDetailsDTO);
}
