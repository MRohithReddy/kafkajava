package com.rohith.javakafka.model.Reservation;

import java.util.List;

import com.rohith.javakafka.model.Theatre.TheatreByMovieNameResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

  private String userName;
  private List<TheatreByMovieNameResponse> theatreByMovieNameResponse;
}