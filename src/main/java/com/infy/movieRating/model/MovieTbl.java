package com.infy.movieRating.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOVIE_TBL")
public class MovieTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", columnDefinition = "numeric")
    private Integer movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @OneToMany(mappedBy = "movieTbl")
    private List<RatingTbl> ratingTbl;

    public MovieTbl() {}

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<RatingTbl> getRatingTbl() {
        return ratingTbl;
    }

    public void setRatingTbl(List<RatingTbl> ratingTbl) {
        this.ratingTbl = ratingTbl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTbl movieTbl = (MovieTbl) o;
        return Objects.equals(movieId, movieTbl.movieId) &&
                Objects.equals(movieName, movieTbl.movieName) &&
                Objects.equals(ratingTbl, movieTbl.ratingTbl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, ratingTbl);
    }
}
