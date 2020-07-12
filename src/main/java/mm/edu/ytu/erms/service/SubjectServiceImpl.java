package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Subject;

import mm.edu.ytu.erms.repository.SubjectRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Subject> pagedResult = subjectRepository.findAll(paging);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }else{
            return new ArrayList<Subject>();
        }
    }

    @Override
    public Subject getById(String code) {
        return subjectRepository.getOne(code);
    }

    @Override
    public Subject getByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public Subject update(Subject subject) {
        Subject oldData = subjectRepository.getOne(subject.getCode());
        BeanUtils.copyProperties(subject, oldData);
        return subjectRepository.saveAndFlush(oldData);
    }

    @Override
    public void delete(String code) {
        subjectRepository.deleteById(code);
    }
}
