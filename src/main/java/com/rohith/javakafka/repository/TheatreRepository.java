package com.rohith.javakafka.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rohith.javakafka.model.Theatre.Theatre;
import com.rohith.javakafka.model.Theatre.TheatreByMovieNameResponse;
import com.rohith.javakafka.model.Theatre.TheatreResponse;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{

  Optional<TheatreResponse> findByMovieName(String movie_name);

  @Query(value = "SELECT screen_id, total_seats_available FROM theatre WHERE movie_name = :movie_name", nativeQuery = true)
  List<TheatreByMovieNameResponse> findAvailabilityByMovieName(@Param("movie_name") String movie_name);
  
}
