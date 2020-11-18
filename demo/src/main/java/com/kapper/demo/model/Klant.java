package com.kapper.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String naam;

    @OneToMany(mappedBy = "klant")
    @JsonIgnore
    Set<Reservation> results;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Set<Reservation> getResults() {
        return results;
    }

    public void setResults(Set<Reservation> results) {
        this.results = results;
    }
}
