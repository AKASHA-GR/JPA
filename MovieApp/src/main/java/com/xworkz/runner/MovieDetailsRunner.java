package com.xworkz.runner;

import com.xworkz.dto.MovieDetailsDTO;
import com.xworkz.service.MovieDetailService;
import com.xworkz.service.impl.MovieDetailServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsRunner {
    public static void main(String[] args) {

        MovieDetailsDTO movieDetailsDTO = new MovieDetailsDTO("Toxic","Action","Kannada,English", 350.0,3,7.5);

        MovieDetailService movieDetailService = new MovieDetailServiceImpl();
        movieDetailService.validateAndSave(movieDetailsDTO);

        List<MovieDetailsDTO> movieDetailsDTOList = new ArrayList<>();
        movieDetailsDTOList.add(new MovieDetailsDTO("Kantara","Drama","Kannada",250.0,3,8.2));
        movieDetailsDTOList.add(new MovieDetailsDTO("KGF","Drama","Kannada",300.0,3,8.8));
        movieDetailsDTOList.add(new MovieDetailsDTO("Rajkumara","Action","Kannada",250.0,2,8.0));

        MovieDetailService movieDetailService1 = new MovieDetailServiceImpl();
        movieDetailService1.validateAndSave(movieDetailsDTOList);
    }
}
