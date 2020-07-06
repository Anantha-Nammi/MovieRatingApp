package com.infy.movieRating.dto;

public class MovieRatingDto {

    private Integer movieId;
    private Integer rating;
    private String movieName;
    private double avgRating;
    private Integer id;
    private String firstName;
    private String lastName;
    private Double customerAvgRating;

    public MovieRatingDto() {}

    public MovieRatingDto(Integer movieId,Integer rating,String movieName) {
        this.movieId = movieId;
        this.rating = rating;
        this.movieName = movieName;
    }

    public MovieRatingDto(Integer id,Integer rating,String firstName,String lastName,String movieName) {
        this.id = id;
        this.rating = rating;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public Double getCustomerAvgRating() {
        return customerAvgRating;
    }

    public void setCustomerAvgRating(Double customerAvgRating) {
        this.customerAvgRating = customerAvgRating;
    }
}
