package com.rohith.javakafka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.rohith.javakafka.model.Theatre.Theatre;
import com.rohith.javakafka.model.Theatre.TheatreByMovieNameResponse;
import com.rohith.javakafka.model.Theatre.TheatreResponse;
import com.rohith.javakafka.repository.TheatreRepository;

@Service
public class TheatreService {
  
  private TheatreRepository theatreRepository;

  public TheatreService(TheatreRepository theatreRepository) {
    this.theatreRepository = theatreRepository;
  }

  public TheatreResponse save(TheatreResponse theatreResponse) {
  //  long total = theatreResponse.getRegular_seats_available()+theatreResponse.getRecliner_seats_available()+theatreResponse.getSofa_seats_available();
    Theatre theatre = new Theatre();
    theatre.setMovieName(theatreResponse.getMovieName());
    theatre.setRecliner_seats_available(theatreResponse.getRecliner_seats_available());
    theatre.setRegular_seats_available(theatreResponse.getRegular_seats_available());
    theatre.setScreen_id(theatreResponse.getScreen_id());
    theatre.setScreen_size(theatreResponse.getScreen_size());
    theatre.setSeat_type(theatreResponse.getSeat_type());
    theatre.setSofa_seats_available(theatreResponse.getSofa_seats_available());
    theatre.setTotal_seats_available(theatreResponse.getTotal_seats_available());

    Theatre saved = theatreRepository.save(theatre);

    TheatreResponse response = new TheatreResponse();
    response.setMovieName(saved.getMovieName());
    response.setScreen_id(saved.getScreen_id());
    response.setScreen_size(saved.getScreen_size());
    response.setRegular_seats_available(saved.getRegular_seats_available());
    response.setSofa_seats_available(saved.getSofa_seats_available());
    response.setRecliner_seats_available(saved.getRecliner_seats_available());
    response.setTotal_seats_available(saved.getTotal_seats_available());
    response.setSeat_type(saved.getSeat_type());
    
    return response;

    // long total = theatreResponse.getRegular_seats_available()+theatreResponse.getRecliner_seats_available()+theatreResponse.getSofa_seats_available();
    // if (theatreResponse.getTotal_seats_available() == null)
    //   theatreResponse.setTotal_seats_available(total);
    // else
    //   if (theatreResponse.getTotal_seats_available() != total)
    //     return null; 
    // if (theatreRepository.findByMovieName(theatreResponse.getMovieName()).isPresent())
    //   return null;
    // long total = theatreResponse.getRegular_seats_available()+theatreResponse.getRecliner_seats_available()+theatreResponse.getSofa_seats_available();
    // if (theatreResponse.getTotal_seats_available() == null)
    //   theatreResponse.setTotal_seats_available(total);
    // else
    //   if (theatreResponse.getTotal_seats_available() != total)
    //     return null; 
    // return theatreRepository.save(theatreResponse);
  }

  public List<TheatreResponse> getAllTheatres() {
      return theatreRepository.findAll()
              .stream()
              .map(this::mapToResponse)
              .collect(Collectors.toList());
  }

  private TheatreResponse mapToResponse(Theatre theatre) {
    return new TheatreResponse(
            theatre.getScreen_id(),
            theatre.getScreen_size(),
            theatre.getRegular_seats_available(),
            theatre.getSofa_seats_available(),
            theatre.getRecliner_seats_available(),
            theatre.getTotal_seats_available(),
            theatre.getSeat_type(),
            theatre.getMovieName()
    );
}

  public Theatre getTheatreById(Long id) {
    return theatreRepository.getReferenceById(id);
  }

  public Optional<TheatreResponse> getTheatreByMoviename(String movie_name) {
    return theatreRepository.findByMovieName(movie_name);
  }

  public List<TheatreByMovieNameResponse> getScreenIdAndTotalSeatsAvailable(String movie_name) {
    return theatreRepository.findAvailabilityByMovieName(movie_name);
  }

}
