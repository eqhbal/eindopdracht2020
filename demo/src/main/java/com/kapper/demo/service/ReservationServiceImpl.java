package com.kapper.demo.service;

import com.kapper.demo.exceptions.RecordNotFoundException;
import com.kapper.demo.exceptions.UserNotFoundException;
import com.kapper.demo.model.Kapper;
import com.kapper.demo.model.Klant;
import com.kapper.demo.model.Reservation;
import com.kapper.demo.model.ReservationKey;
import com.kapper.demo.repository.KapperRepository;
import com.kapper.demo.repository.KlantRepository;
import com.kapper.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    KlantRepository klantRepository;

    @Autowired
    KapperRepository kapperRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public Collection<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Collection<Reservation> getAllReservationByKlant(long klantId) {
        return reservationRepository.findAllByKlantId(klantId);
    }

    @Override
    public Collection<Reservation> getAllReservationByKapper(long kapperId) {
        return reservationRepository.findAllByKapperId(kapperId);
    }

    @Override
    public Reservation getReservationById(long klantId, long kapperId) {
        return reservationRepository.findById(new ReservationKey(klantId, kapperId)).orElse((null));
    }

    @Override
    public ReservationKey createReservation(long klantId, long kapperId, Reservation result) {
        if (!klantRepository.existsById(klantId)) { throw new RecordNotFoundException(); }
        Klant klant = klantRepository.findById(klantId).orElse(null);
        if (!kapperRepository.existsById(kapperId)) { throw new RecordNotFoundException(); }
        Kapper kapper = kapperRepository.findById(kapperId).orElse(null);
        result.setKlant(klant);
        result.setKapper(kapper);
        ReservationKey id = new ReservationKey(klantId, kapperId);
        result.setId(id);
        reservationRepository.save(result);
        return id;
    }


    @Override
    public void updateReservation(long klantId, long kapperId, Reservation result) {
        ReservationKey id = new ReservationKey(klantId, kapperId);
        if (!reservationRepository.existsById(id)) { throw new RecordNotFoundException(); }
        Reservation existingResult = reservationRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
        existingResult.setKlant(result.getKlant());
        existingResult.setKapper(result.getKapper());
        reservationRepository.save(existingResult);

    }

    @Override
    public void partialUpdateReservation(long klantId, long kapperId, Reservation result) {

    }

    @Override
    public void deleteReservation(long klantId, long kapperId) {
        ReservationKey id = new ReservationKey(klantId, kapperId);
        if (!reservationRepository.existsById(id)) { throw new RecordNotFoundException(); }
        reservationRepository.deleteById(id);

    }
}
