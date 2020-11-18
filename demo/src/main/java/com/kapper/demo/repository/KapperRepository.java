package com.kapper.demo.repository;

import com.kapper.demo.model.Kapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface KapperRepository extends JpaRepository<Kapper, Long> {
        Collection<Kapper> findAllByNaam(String naam);
}

