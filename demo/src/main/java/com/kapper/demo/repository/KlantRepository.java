package com.kapper.demo.repository;

import com.kapper.demo.model.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface KlantRepository extends JpaRepository<Klant, Long> {
    Collection<Klant> findAllByNaam(String naam);

}
