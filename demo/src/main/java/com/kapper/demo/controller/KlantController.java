package com.kapper.demo.controller;

import com.kapper.demo.model.Klant;
import com.kapper.demo.model.Reservation;
import com.kapper.demo.model.ReservationKey;
import com.kapper.demo.service.KlantService;
import com.kapper.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping(value = "/klanten")
public class KlantController {



    @Autowired
    KlantService klantService;

    @Autowired
    ReservationService reservationService;

    //CRUD(Create Read Update Delete) Methodes****************************************************

    //Get klanten ---------------------------------------------------------------------------

    @GetMapping(value = "")
    public ResponseEntity<Object> zoekKlanten(@RequestParam(name = "naam", defaultValue = "") String naam) {
        return ResponseEntity.ok().body(klantService.getKlant(naam));
    }

    //Get klant---------------------------------------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getKlant(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(klantService.getKlantById(id));
    }

    //Create klant ---------------------------------------------------------------------------

    @PostMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createKlant(@RequestBody Klant klant) {
        long newId = klantService.createKlant(klant);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    //Update klant---------------------------------------------------------------------------

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateKlant(@PathVariable("id") long id, @RequestBody Klant klant) {
        klantService.updateklant(id, klant);
        return ResponseEntity.noContent().build();
    }

    //Partial update klant ---------------------------------------------------------------------------

    @PatchMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> partialUpdateKlant(@PathVariable("id") long id, @RequestBody Map<String , String> fields) {
        klantService.partialUpdateKlant(id, fields);
        return ResponseEntity.noContent().build();
    }

    //Delete klant ---------------------------------------------------------------------------

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteKlant(@PathVariable("id") long id) {
        klantService.deleteklant(id);
        return ResponseEntity.noContent().build();
    }

    //Reserveration methoden***********************************************************************


    //Reservering ophalen------------------------------------------------------------------------

    @GetMapping(value = "/{klant_id}/kappers/{kapper_id}")
    public ResponseEntity<Object> getReservation(@PathVariable("klant_id") long klantId,
                                                         @PathVariable("kapper_id") long kapperId) {
        return ResponseEntity.ok().body(reservationService.getReservationById(klantId, kapperId));
    }

    //Reservering maken------------------------------------------------------------------------

    @PostMapping(value = "/{klant_id}/kappers/{kapper_id}")
    public ResponseEntity<Object> makeReservation(@PathVariable("klant_id") long klantId,
                                                         @PathVariable("kapper_id") long kapperId,
                                                         @RequestBody Reservation result) {
        ReservationKey newId = reservationService.createReservation(klantId, kapperId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

    //Reservering Verwijderen------------------------------------------------------------------------

    @DeleteMapping(value = "/{klant_id}/kappers/{kapper_id}\"")
    public ResponseEntity<Object> deleteReservation(@PathVariable("klant_id") long klantId,
                                                    @PathVariable("kapper_id") long kapperId,
                                                    @RequestBody Reservation result) {
        reservationService.deleteReservation(klantId, kapperId);
        return ResponseEntity.noContent().build();
    }


}
