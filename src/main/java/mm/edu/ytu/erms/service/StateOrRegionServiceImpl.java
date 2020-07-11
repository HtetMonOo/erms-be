package mm.edu.ytu.erms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.StateOrRegion;
import mm.edu.ytu.erms.repository.StateOrRegionRepository;

@Service
public class StateOrRegionServiceImpl implements StateOrRegionService {

    @Autowired
    private StateOrRegionRepository stateOrRegionRepository;

    @Override
    public List<StateOrRegion> getAll() {
        return stateOrRegionRepository.findAll();
    }

    @Override
    public StateOrRegion getById(Integer id) {
        return stateOrRegionRepository.getOne(id);
    }

    @Override
    public StateOrRegion save(StateOrRegion stateOrRegion) {
        return stateOrRegionRepository.saveAndFlush(stateOrRegion);
    }

    @Override
    public StateOrRegion update(StateOrRegion stateOrRegion) {
        return stateOrRegionRepository.saveAndFlush(stateOrRegion);
    }

    @Override
    public void deleteById(Integer id) {
        stateOrRegionRepository.deleteById(id);

    }
    
}