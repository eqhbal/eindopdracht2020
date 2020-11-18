package com.kapper.demo.repository;

import com.kapper.demo.model.Reservation;
import com.kapper.demo.model.ReservationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository <Reservation, ReservationKey> {
    Collection<Reservation> findAllByKlantId(long klantId);
    Collection<Reservation> findAllByKapperId(long kapperId);
}
