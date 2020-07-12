package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Major;
import mm.edu.ytu.erms.repository.MajorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorRepository majorRepository;

    @Override
    public List<Major> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Major> pagedResult = majorRepository.findAll(paging);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }else{
            return new ArrayList<Major>();
        }
    }

    @Override
    public Major getById(String code) {
        return majorRepository.getOne(code);
    }

    @Override
    public Major create(Major major) {
        return majorRepository.saveAndFlush(major);
    }

    @Override
    public Major update(Major major) {
        Major oldData = majorRepository.getOne(major.getCode());
        BeanUtils.copyProperties(major, oldData, "dateCreated");
        System.out.println("In serviceImpl");
        return majorRepository.saveAndFlush(oldData);
    }

    @Override
    public void delete(String code) {
        majorRepository.deleteById(code);
    }
}
