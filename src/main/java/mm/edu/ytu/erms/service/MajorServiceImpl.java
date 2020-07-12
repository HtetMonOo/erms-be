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

    @Override
    public List<Major> getAll() {
        return majorRepository.findAll();
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
