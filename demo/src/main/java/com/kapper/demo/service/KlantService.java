package com.kapper.demo.service;

import com.kapper.demo.model.Klant;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface KlantService {

    Collection<Klant> getAllKlanten();
    Klant getKlantById(long id);
    Collection<Klant> getKlant(String naam);
    public abstract long createKlant(Klant klant);
    public abstract void updateklant(long id, Klant klant);
    void partialUpdateKlant(long id, Map<String, String> fields);
    public abstract void deleteklant(long id);


}
