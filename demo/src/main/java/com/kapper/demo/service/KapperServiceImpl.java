package com.kapper.demo.service;

import com.kapper.demo.exceptions.UserNotFoundException;
import com.kapper.demo.model.Kapper;
import com.kapper.demo.repository.KapperRepository;
import com.kapper.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class KapperServiceImpl implements KapperService {

    @Autowired
    KapperRepository kapperRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public Collection<Kapper> getAllKappers() { return kapperRepository.findAll(); }

    @Override
    public Collection<Kapper> getKapper(String naam) {
        if (naam.isEmpty()) {
            return kapperRepository.findAll();
        }
        else {
            return kapperRepository.findAllByNaam(naam);
        }
    }

    @Override
    public Kapper getKapperById(long id) {
        if (!kapperRepository.existsById(id)) { throw new UserNotFoundException(); }
        return kapperRepository.findById(id).orElse(null);
    }

    @Override
    public long createKapper(Kapper kapper) {
        Kapper storedKapper = kapperRepository.save(kapper);
        return storedKapper.getId();
    }

    @Override
    public void updateKapper(long id, Kapper Kapper) {
        if(!kapperRepository.existsById(id)) {throw new UserNotFoundException(); }
        Kapper storedKapper = kapperRepository.findById(id).orElse(null);
        storedKapper.setNaam(Kapper.getNaam());
        kapperRepository.save(Kapper);
    }

    @Override
    public void partialUpdateKapper(long id, Map<String, String> fields) {
        if (!kapperRepository.existsById(id)) { throw new UserNotFoundException(); }
        Kapper storedKapper = kapperRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "name":
                    storedKapper.setNaam((String) fields.get(field));
                    break;
            }
        }
        kapperRepository.save(storedKapper);

    }

    @Override
    public void deleteKapper(long id) {
        if(!kapperRepository.existsById(id)) { throw new UserNotFoundException(); }
        kapperRepository.deleteById(id);
    }




}
