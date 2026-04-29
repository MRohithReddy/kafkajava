package com.rohith.javakafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohith.javakafka.model.Reservation.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  


}
