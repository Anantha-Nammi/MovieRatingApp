package com.infy.movieRating.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "RATING_TBL")
public class RatingTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATING_ID", columnDefinition = "numeric")
    private Integer ratingId;

    @Column(name = "RATING")
    private Integer rating;

    //@MapsId("movieId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID",referencedColumnName = "MOVIE_ID",nullable=false)
    private MovieTbl movieTbl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_ID",referencedColumnName = "CUST_ID",nullable=false)
    private CustomerTbl customerTbl;

    public RatingTbl () {}

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public MovieTbl getMovieTbl() {
        return movieTbl;
    }

    public void setMovieTbl(MovieTbl movieTbl) {
        this.movieTbl = movieTbl;
    }

    public CustomerTbl getCustomerTbl() {
        return customerTbl;
    }

    public void setCustomerTbl(CustomerTbl customerTbl) {
        this.customerTbl = customerTbl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingTbl ratingTbl = (RatingTbl) o;
        return Objects.equals(ratingId, ratingTbl.ratingId) &&
                Objects.equals(rating, ratingTbl.rating) &&
                Objects.equals(movieTbl, ratingTbl.movieTbl) &&
                Objects.equals(customerTbl, ratingTbl.customerTbl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, rating, movieTbl, customerTbl);
    }
}
