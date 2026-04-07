package com.rohith.javakafka.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohith.javakafka.model.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{

  Optional<Theatre> findByMovieName(String movie_name);
  
}
