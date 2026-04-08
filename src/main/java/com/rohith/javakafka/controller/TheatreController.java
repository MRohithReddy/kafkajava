package com.rohith.javakafka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.javakafka.model.Theatre;
import com.rohith.javakafka.model.TheatreByMovieNameResponse;
import com.rohith.javakafka.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

  @Autowired
  private TheatreService theatreService;

  @PostMapping
  public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
    if (theatreService.save(theatre)!=null) {
      return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(theatreService.save(theatre));
    }
    else
      return ResponseEntity
              .status(HttpStatus.NOT_ACCEPTABLE)
              .body(null);
  }

  @GetMapping
  public ResponseEntity<List<Theatre>> getAllTheatres() {
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(theatreService.getAllTheatres());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Theatre> getTheatreById(@PathVariable Long id) {
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(theatreService.getTheatreById(id));
  }

  @GetMapping("/movieName")
  public ResponseEntity<Optional<Theatre>> getTheatreByMovieName(@RequestParam String movie_name) {
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(theatreService.getTheatreByMoviename(movie_name));
  }

  @GetMapping("/movieName/availability")
  public ResponseEntity<List<TheatreByMovieNameResponse>> getScreenIdAndTotalSeatsAvailable(@RequestParam String movie_name) {
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(theatreService.getScreenIdAndTotalSeatsAvailable(movie_name));
  }
}
