package com.rohith.javakafka.service;

import org.springframework.stereotype.Service;

import com.rohith.javakafka.model.Reservation.Reservation;
import com.rohith.javakafka.repository.ReservationRepository;

@Service
public class ReservationService {
  
  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public Reservation save(Reservation reservation) {
    Reservation saved = reservationRepository.save(reservation);
    return saved;
  }

}
