package com.xworkz.dao;

import com.xworkz.entity.MovieDetailsEntity;

import java.util.List;

public interface MovieDetailsDAO {
    public Boolean save(MovieDetailsEntity movieDetailsEntity);
    public Boolean saveAll(List<MovieDetailsEntity> movieDetailsEntity);
}
