package com.kapper.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
//Serializable betekend dit een string maakt en dat string wordt gebruikt als aparte key
public class ReservationKey implements Serializable {

    @Column(name = "klant_id")
    private Long klantId;

    @Column(name = "kapper_id")
    private Long kapperId;

    //Constructors--------------------------------------------------------------------

    public ReservationKey() {}
    public ReservationKey(long klantId, long kapperId) {
        this.klantId = klantId;
        this.kapperId = kapperId;
    }

    //Getters en Setters---------------------------------------------------------------

    public Long getKlantId() { return klantId; }
    public void setKlantId(Long klantId) { this.klantId = klantId; }
    public Long getKapperId() { return kapperId; }
    public void setKapperId(Long kapperId) { this.kapperId = kapperId; }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationKey that = (ReservationKey) o;
        return klantId.equals(that.klantId) &&
                kapperId.equals(that.kapperId);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(klantId, kapperId);
    }

}

