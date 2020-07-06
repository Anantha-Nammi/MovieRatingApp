package com.infy.movieRating.repository;


import com.infy.movieRating.model.CustomerTbl;
import com.infy.movieRating.model.MovieTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerTbl, Integer>, JpaSpecificationExecutor<CustomerTbl> {
}
