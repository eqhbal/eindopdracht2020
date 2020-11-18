package com.kapper.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation {

    @EmbeddedId
    private ReservationKey id;

    @ManyToOne
    @MapsId("klantId")
    @JoinColumn(name = "klant_id")
    private Klant klant;


    @ManyToOne
    @MapsId("kapperId")
    @JoinColumn(name = "kapper_id")
    private Kapper kapper;

    @Column
    private LocalDate date;

    public Reservation() {
        date = LocalDate.now();
    }
    public ReservationKey getId() { return id; }
    public void setId(ReservationKey id) {
        this.id = id;
    }
    public Klant getKlant() { return klant; }
    public void setKlant(Klant klant) { this.klant = klant; }
    public Kapper getKapper() { return kapper; }
    public void setKapper(Kapper kapper) { this.kapper = kapper; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

}
