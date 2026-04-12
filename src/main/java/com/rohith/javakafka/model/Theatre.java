package com.rohith.javakafka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theatre")
@Getter
@Setter
public class Theatre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long screen_id;
  
  private Long screen_size, regular_seats_available, sofa_seats_available, recliner_seats_available, total_seats_available;
  
  private String seat_type;

  @Column(name = "movie_name")
  private String movieName;
  
}
