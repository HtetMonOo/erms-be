package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.StateOrRegion;

public interface StateOrRegionService {
    List<StateOrRegion> getAll();
    StateOrRegion getById(Integer id);
    StateOrRegion save(StateOrRegion stateOrRegion);
    StateOrRegion update(StateOrRegion stateOrRegion);
    void deleteById(Integer id);
}