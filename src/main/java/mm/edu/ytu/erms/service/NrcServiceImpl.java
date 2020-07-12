package mm.edu.ytu.erms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Nrc;
import mm.edu.ytu.erms.repository.NrcRepository;

@Service
@Transactional
public class NrcServiceImpl implements NrcService {

    @Autowired
    private NrcRepository nrcRepository;

    @Override
    public List<Nrc> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Nrc> pagedResult = nrcRepository.findAll(paging);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }else{
            return new ArrayList<Nrc>();
        }
    }

    @Override
    public Nrc getByCode(String code) {
        return nrcRepository.getOne(code);
    }

    @Override
    public Nrc save(Nrc nrc) {
        return nrcRepository.saveAndFlush(nrc);
    }

    @Override
    public Nrc update(Nrc nrc) {
        Nrc oldNrc=nrcRepository.getOne(nrc.getCode());
        BeanUtils.copyProperties(nrc, oldNrc,"code","dateCreated");
        return nrcRepository.saveAndFlush(nrc);
    }

    @Override
    public void deleteByCode(String code) {
        nrcRepository.deleteById(code);
    }
    
}