package com.infy.movieRating.controller;

import com.infy.movieRating.dto.MovieRatingDto;
import com.infy.movieRating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/customer/{custId}/rate/{rating}")
    public String saveCustomerRating(@PathVariable("custId") Integer custId,
                                     @PathVariable("rating") Integer rating, @RequestParam("movieName") String movieName) {
        movieService.saveCustomerRating(custId,rating,movieName);
        return "Customer rating saved successfully";
    }

    @GetMapping("/customerRating/{custId}")
    public MovieRatingDto getCustomerRating(@PathVariable("custId") Integer custId) {

        return movieService.getCustomerRating(custId);
    }

    @GetMapping("/highestMovieRate")
    public Map.Entry<String,Double> getHighestMovieRate() {
        return movieService.getHighestMovieRating();
    }
}
