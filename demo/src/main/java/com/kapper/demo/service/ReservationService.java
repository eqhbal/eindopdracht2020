package com.kapper.demo.service;

import com.kapper.demo.model.Reservation;
import com.kapper.demo.model.ReservationKey;

import java.util.Collection;

public interface ReservationService {

    Collection<Reservation> getAllReservations();
    Collection<Reservation> getAllReservationByKlant(long klantId);
    Collection<Reservation> getAllReservationByKapper(long kapperId);
    Reservation getReservationById(long klantId, long kapperId);

    ReservationKey createReservation(long klantId, long kapperId, Reservation result);
    void updateReservation(long klantId, long kapperId, Reservation result);
    void partialUpdateReservation(long klantId, long kapperId, Reservation result);
    void deleteReservation(long klantId, long kapperId);

}
