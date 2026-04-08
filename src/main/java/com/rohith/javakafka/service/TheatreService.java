package com.rohith.javakafka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.rohith.javakafka.model.Theatre;
import com.rohith.javakafka.model.TheatreByMovieNameResponse;
import com.rohith.javakafka.repository.TheatreRepository;

@Service
public class TheatreService {
  
  private TheatreRepository theatreRepository;

  public TheatreService(TheatreRepository theatreRepository) {
    this.theatreRepository = theatreRepository;
  }

  public Theatre save(Theatre theatre) {
    long total = theatre.getRegular_seats_available()+theatre.getRecliner_seats_available()+theatre.getSofa_seats_available();
    if (theatre.getTotal_seats_available() == null)
      theatre.setTotal_seats_available(total);
    else
      if (theatre.getTotal_seats_available() != total)
        return null; 
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

  public List<TheatreByMovieNameResponse> getScreenIdAndTotalSeatsAvailable(String movie_name) {
    return theatreRepository.findAvailabilityByMovieName(movie_name);
  }

}
