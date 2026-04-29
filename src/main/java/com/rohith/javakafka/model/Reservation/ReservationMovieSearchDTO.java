package com.rohith.javakafka.model.Reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationMovieSearchDTO {

  private String userName, movieName;

}