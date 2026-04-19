package com.rohith.javakafka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {
  
  @Id
  private Long userId;

  private String userName;

}
