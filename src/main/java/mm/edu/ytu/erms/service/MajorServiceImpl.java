package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Major;
import mm.edu.ytu.erms.repository.MajorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorRepository majorRepository;

    public List<Major> getAll(){
        return majorRepository.findAll();
    }

    public Major getByCode(String code){
        return majorRepository.findByCodeContains(code);
    }

    public Major create(Major major){
        return majorRepository.saveAndFlush(major);
    }

    public Major update(Major major){
        Major oldData = majorRepository.getOne(major.getCode());
        BeanUtils.copyProperties(major, oldData, "dateCreated");
        System.out.println("In serviceImpl");
        return majorRepository.saveAndFlush(oldData);
    }

    public void delete(String code){
        majorRepository.deleteById(code);
    }
}
