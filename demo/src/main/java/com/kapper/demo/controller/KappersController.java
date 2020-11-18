package com.kapper.demo.controller;

import com.kapper.demo.model.Kapper;

import com.kapper.demo.model.Reservation;
import com.kapper.demo.model.ReservationKey;
import com.kapper.demo.service.KapperService;
import com.kapper.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping(value = "/kappers")
public class KappersController {

    @Autowired
    KapperService kapperService;

    @Autowired
    ReservationService reservationService;



    //CRUD(Create Read Update Delete) Methodes****************************************************


    //Get all kappers ---------------------------------------------------------------------------

    @GetMapping(value = "")
    public ResponseEntity<Object> zoekKappers(@RequestParam(name = "naam", defaultValue = "") String naam) {
        return ResponseEntity.ok().body(kapperService.getKapper(naam));
    }

    //Get Kapper ---------------------------------------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getKapper(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(kapperService.getKapperById(id));
    }

    //Create kapper ---------------------------------------------------------------------------

    @PostMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createKapper(@RequestBody Kapper kapper) {
        long newId = kapperService.createKapper(kapper);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    //Update kapper ---------------------------------------------------------------------------

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateKapper(@PathVariable("id") long id, @RequestBody Kapper kapper) {
        kapperService.updateKapper(id, kapper);
        return ResponseEntity.noContent().build();
    }

    //Partial update kapper ---------------------------------------------------------------------------

    @PatchMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> partialUpdatekapper(@PathVariable("id") long id, @RequestBody Map<String , String> fields) {
        kapperService.partialUpdateKapper(id, fields);
        return ResponseEntity.noContent().build();
    }

    //Delete kapper ---------------------------------------------------------------------------

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteKapper(@PathVariable("id") long id) {
        kapperService.deleteKapper(id);
        return ResponseEntity.noContent().build();
    }

    //Reserveration methoden***********************************************************************


    //Reservering ophalen------------------------------------------------------------------------

    @GetMapping(value = "/{kapper_id}/klanten/{klant_id}")
    public ResponseEntity<Object> getReservation(@PathVariable("kapper_id") long kapperId,
                                                 @PathVariable("klant_id") long klantId) {
        return ResponseEntity.ok().body(reservationService.getReservationById(kapperId, klantId));
    }

    //Reservering maken------------------------------------------------------------------------

    @PostMapping(value = "/{kapper_id}/klanten/{klant_id}")
    public ResponseEntity<Object> makeReservation(@PathVariable("kapper_id") long kapperId,
                                                  @PathVariable("klant_id") long klantId,
                                                  @RequestBody Reservation result) {
        ReservationKey newId = reservationService.createReservation(kapperId, klantId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

    //Reservering Verwijderen------------------------------------------------------------------------

    @DeleteMapping(value = "/{kapper_id}/klanten/{klant_id}")
    public ResponseEntity<Object> deleteReservation(@PathVariable("kapper_id") long kapperId,
                                                    @PathVariable("klant_id") long klantId,
                                                    @RequestBody Reservation result) {
        reservationService.deleteReservation(kapperId, klantId);
        return ResponseEntity.noContent().build();
    }

}
