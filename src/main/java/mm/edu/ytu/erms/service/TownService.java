package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Town;

public interface TownService {
    List<Town> getAll();
    Town getByPCode(String pCode);
    Town save(Town town);
    Town update(Town town);
    void deleteByPCode(String code);
}