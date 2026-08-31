package com.xworkz.service.impl;

import com.xworkz.dao.MovieDetailsDAO;
import com.xworkz.dao.impl.MovieDetailsDAOImpl;
import com.xworkz.dto.MovieDetailsDTO;
import com.xworkz.entity.MovieDetailsEntity;
import com.xworkz.service.MovieDetailService;

import java.util.List;

public class MovieDetailServiceImpl implements MovieDetailService {
    MovieDetailsDAO movieDetailsDAO = new MovieDetailsDAOImpl();

    @Override
    public String validateAndSave(MovieDetailsDTO movieDetailsDTO) {
        String validate = "The DTO is not Valid";

        MovieDetailsEntity movieDetailsEntity = new MovieDetailsEntity();
        movieDetailsEntity.setTitle(movieDetailsDTO.getTitle());
        movieDetailsEntity.setGenre(movieDetailsDTO.getGenre());
        movieDetailsEntity.setLanguage(movieDetailsDTO.getLanguage());
        movieDetailsEntity.setCast(movieDetailsDTO.getCast());
        movieDetailsEntity.setDuration(movieDetailsDTO.getDuration());
        movieDetailsEntity.setRating(movieDetailsDTO.getRating());

        Boolean valid = movieDetailsDAO.save(movieDetailsEntity);

        if (valid){
            System.out.println("The movie is saved to DB");
        }else{
            System.out.println("The movie is not saved to DB");
        }

        return validate;
    }

    @Override
    public String validateAndSave(List<MovieDetailsDTO> movieDetailsDTO) {
        String validate = "The List of DTO is not Valid";

        List<MovieDetailsEntity> movieDetailsEntityList = movieDetailsDTO.stream()
                .map(MovieDetailsDTO -> new MovieDetailsEntity(MovieDetailsDTO.getTitle(),MovieDetailsDTO.getGenre(),MovieDetailsDTO.getLanguage(),MovieDetailsDTO.getCast(),MovieDetailsDTO.getDuration(),MovieDetailsDTO.getRating()))
                .toList();

        Boolean valid = movieDetailsDAO.saveAll(movieDetailsEntityList);

        if (valid){
            System.out.println("The List of  movie is saved to DB");
        }else{
            System.out.println("The List of movie is not saved to DB");
        }

        return validate;

    }
}
