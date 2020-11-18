package com.kapper.demo.service;

import com.kapper.demo.model.Kapper;

import java.util.Collection;
import java.util.Map;

public interface KapperService {

    Collection<Kapper> getAllKappers();
    Kapper getKapperById(long id);
    Collection<Kapper> getKapper(String naam);
    public abstract long createKapper(Kapper kapper);
    public abstract void updateKapper(long id, Kapper kapper);
    void partialUpdateKapper(long id, Map<String, String> fields);
    public abstract void deleteKapper(long id);


}
