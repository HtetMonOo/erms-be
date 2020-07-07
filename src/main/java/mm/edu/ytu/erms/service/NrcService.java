package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Nrc;

public interface NrcService {
    List<Nrc> getAll();
    Nrc getByCode(String code);
    Nrc save(Nrc nrc);
    Nrc update(Nrc nrc);
    void deleteByCode(String code);
}