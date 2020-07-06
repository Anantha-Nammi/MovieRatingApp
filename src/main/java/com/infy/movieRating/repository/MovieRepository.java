package com.infy.movieRating.repository;

import com.infy.movieRating.model.MovieTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<MovieTbl, Integer>, JpaSpecificationExecutor<MovieTbl> {

    MovieTbl findByMovieName(String movieName);

}
