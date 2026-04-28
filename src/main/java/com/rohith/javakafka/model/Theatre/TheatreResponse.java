package com.rohith.javakafka.model.Theatre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreResponse {

  private Long screen_id, screen_size, regular_seats_available, sofa_seats_available, recliner_seats_available, total_seats_available;
  
  private String seat_type, movieName;
  
}