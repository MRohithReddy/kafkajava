package com.rohith.javakafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TheatreByMovieNameResponse {
  private Long screen_id, total_seats_available;
}
