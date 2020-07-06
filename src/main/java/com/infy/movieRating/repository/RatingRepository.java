package com.infy.movieRating.repository;

import com.infy.movieRating.dto.MovieRatingDto;
import com.infy.movieRating.model.RatingTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingTbl, Integer>, JpaSpecificationExecutor<RatingTbl> {

    @Query("select new com.infy.movieRating.dto.MovieRatingDto(r.movieTbl.movieId,r.rating,r.movieTbl.movieName) from RatingTbl r " +
            "inner join MovieTbl m on r.movieTbl.movieId=m.movieId order by r.movieTbl.movieId")
    List<MovieRatingDto> getMovieRatingDetails();

    @Query("select new com.infy.movieRating.dto.MovieRatingDto(r.customerTbl.custId,r.rating,c.firstName,c.lastName,r.movieTbl.movieName) " +
            "from RatingTbl r " +
            "inner join CustomerTbl c on r.customerTbl.custId=c.custId where r.customerTbl.custId=:custId")
    List<MovieRatingDto> getCustomerRatingDetails(Integer custId);

}
