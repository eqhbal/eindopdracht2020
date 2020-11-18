package com.kapper.demo.service;

import com.kapper.demo.exceptions.UserNotFoundException;
import com.kapper.demo.model.Klant;
import com.kapper.demo.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class KlantServiceImpl implements KlantService {

    @Autowired
    KlantRepository klantRepository;


    @Override
    public Collection<Klant> getAllKlanten() { return klantRepository.findAll(); }

    @Override
    public Collection<Klant> getKlant(String naam) {
        if (naam.isEmpty()) {
            return klantRepository.findAll();
        }
        else {
            return klantRepository.findAllByNaam(naam);
        }
    }

    @Override
    public Klant getKlantById(long id) {
        if (!klantRepository.existsById(id)) { throw new UserNotFoundException(); }
        return klantRepository.findById(id).orElse(null);
    }

    @Override
    public long createKlant(Klant klant) {
        Klant storedKlant = klantRepository.save(klant);
        return storedKlant.getId();
    }

    @Override
    public void updateklant(long id, Klant klant) {
        if(!klantRepository.existsById(id)) {throw new UserNotFoundException(); }
        Klant storedKlant = klantRepository.findById(id).orElse(null);
        storedKlant.setNaam(klant.getNaam());
        klantRepository.save(klant);
    }

    @Override
    public void partialUpdateKlant(long id, Map<String, String> fields) {
        if (!klantRepository.existsById(id)) { throw new UserNotFoundException(); }
        Klant storedKlant = klantRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "name":
                    storedKlant.setNaam((String) fields.get(field));
                    break;
            }
        }
        klantRepository.save(storedKlant);

    }

    @Override
    public void deleteklant(long id) {
            if(!klantRepository.existsById(id)) { throw new UserNotFoundException(); }
            klantRepository.deleteById(id);
    }

}
