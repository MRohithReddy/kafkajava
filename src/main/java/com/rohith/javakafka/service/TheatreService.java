package com.rohith.javakafka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rohith.javakafka.model.Theatre;
import com.rohith.javakafka.repository.TheatreRepository;

@Service
public class TheatreService {
  
  private TheatreRepository theatreRepository;

  public TheatreService(TheatreRepository theatreRepository) {
    this.theatreRepository = theatreRepository;
  }

  public Theatre save(Theatre theatre) {
    return theatreRepository.save(theatre);
  }

  public List<Theatre> getAllTheatres() {
    List<Theatre> list = new ArrayList<>();
    list = theatreRepository.findAll();
    return list;
  }

  public Theatre getTheatreById(Long id) {
    return theatreRepository.getReferenceById(id);
  }

  public Optional<Theatre> getTheatreByMoviename(String movie_name) {
    return theatreRepository.findByMovieName(movie_name);
  }

}
