package com.infy.movieRating.service;

import com.infy.movieRating.dto.MovieRatingDto;
import com.infy.movieRating.exception.MovieErrorData;
import com.infy.movieRating.exception.MovieException;
import com.infy.movieRating.model.CustomerTbl;
import com.infy.movieRating.model.MovieTbl;
import com.infy.movieRating.model.RatingTbl;
import com.infy.movieRating.repository.CustomerRepository;
import com.infy.movieRating.repository.MovieRepository;
import com.infy.movieRating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomerRating(Integer custId,Integer rating,String movieName) {
        RatingTbl ratingTbl = new RatingTbl();

        // Get the movie detail by Movie name
        MovieTbl movieTbl = movieRepository.findByMovieName(movieName);
        if(movieTbl == null)
            throw new MovieException("Movie not found :: "+movieName);

        // Get the customer details by passing the customer id
        CustomerTbl customerTbl = customerRepository.findById(custId).orElseThrow(()
                -> new MovieException("Customer id is not found Exception :: " + custId) );

        // Setting the data for movie rating
        ratingTbl.setRating(rating);
        ratingTbl.setCustomerTbl(customerTbl);
        ratingTbl.setMovieTbl(movieTbl);

        // Save the movie rating details in Rating_tbl
        ratingRepository.save(ratingTbl);
    }

    public Map.Entry<String,Double> getHighestMovieRating() {
        List<MovieRatingDto> movieRatingDtoList = ratingRepository.getMovieRatingDetails();

        // Find the all the movies average list
        Map<String, Double> avg = movieRatingDtoList.stream().collect(
                Collectors.groupingBy(MovieRatingDto::getMovieName,
                        Collectors.averagingDouble((MovieRatingDto::getRating))));

        // Get the highest average movie rate
        Map.Entry<String, Double> maxRateMovie = avg.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();

        return maxRateMovie;
    }

    public MovieRatingDto getCustomerRating(Integer custId) {

        List<MovieRatingDto> custRatingDto = ratingRepository.getCustomerRatingDetails(custId);

        //Get the data from the summary Statistics
        DoubleSummaryStatistics summary = custRatingDto.stream()
                .collect(Collectors.summarizingDouble(MovieRatingDto::getRating));

        // Set the movie average summary
        MovieRatingDto custMovieRatingDto = new MovieRatingDto();
        custMovieRatingDto.setId(custRatingDto.get(0).getId());
        custMovieRatingDto.setFirstName(custRatingDto.get(0).getFirstName());
        custMovieRatingDto.setLastName(custRatingDto.get(0).getLastName());
        custMovieRatingDto.setCustomerAvgRating(summary.getMax());
        custMovieRatingDto.setAvgRating(summary.getAverage());
        return custMovieRatingDto;
    }
}
