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

  public TheatreResponse save(TheatreResponse theatreResponse) {
    long total = theatreResponse.getRegular_seats_available()+theatreResponse.getRecliner_seats_available()+theatreResponse.getSofa_seats_available();
    if (theatreResponse.getTotal_seats_available() == null)
      theatreResponse.setTotal_seats_available(total);
    else
      if (theatreResponse.getTotal_seats_available() != total)
        return null; 
    if (theatreRepository.findByMovieName(theatreResponse.getMovieName()).isPresent())
      return null;
    long total = theatreResponse.getRegular_seats_available()+theatreResponse.getRecliner_seats_available()+theatreResponse.getSofa_seats_available();
    if (theatreResponse.getTotal_seats_available() == null)
      theatreResponse.setTotal_seats_available(total);
    else
      if (theatreResponse.getTotal_seats_available() != total)
        return null; 
    return theatreRepository.save(theatre);
  }

  public List<TheatreResponse> getAllTheatres() {
    List<TheatreResponse> list = new ArrayList<>();
    list = theatreRepository.findAll();
    return list;
  }

  public TheatreResponse getTheatreById(Long id) {
    return theatreRepository.getReferenceById(id);
  }

  public Optional<TheatreResponse> getTheatreByMoviename(String movie_name) {
    return theatreRepository.findByMovieName(movie_name);
  }

  public List<TheatreByMovieNameResponse> getScreenIdAndTotalSeatsAvailable(String movie_name) {
    return theatreRepository.findAvailabilityByMovieName(movie_name);
  }

}
