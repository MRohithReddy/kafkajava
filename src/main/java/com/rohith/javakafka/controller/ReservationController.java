package com.rohith.javakafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.javakafka.model.Reservation.Reservation;
import com.rohith.javakafka.model.Reservation.ReservationMovieSearchDTO;
import com.rohith.javakafka.model.Reservation.ReservationResponse;
import com.rohith.javakafka.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
  
  private ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping
  public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
    Reservation savedReservation = reservationService.save(reservation);
    if (savedReservation != null) {
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(savedReservation);
    }
    else
      return ResponseEntity
              .status(HttpStatus.NOT_ACCEPTABLE)
              .body(null);
  }

  @GetMapping("/movieName")
  public ResponseEntity<ReservationResponse> getMovieResultsk(@RequestBody ReservationMovieSearchDTO reservationMovieSearchDTO) {
    return null;
  }

}
