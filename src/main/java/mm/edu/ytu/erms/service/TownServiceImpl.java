package mm.edu.ytu.erms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Town;
import mm.edu.ytu.erms.repository.TownRepository;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository townRepository;

    @Override
    public List<Town> getAll() {
        return townRepository.findAll();
    }

    @Override
    public Town getByPCode(String pCode) {
        return townRepository.getOne(pCode);
    }

    @Override
    public Town save(Town town) {
        return townRepository.saveAndFlush(town);
    }

    @Override
    public Town update(Town town) {
        return townRepository.saveAndFlush(town);
    }

    @Override
    public void deleteByPCode(String pCode) {
        townRepository.deleteById(pCode);
    }
    
}