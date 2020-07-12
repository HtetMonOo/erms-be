package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> getAll(Integer pageNo, Integer pageSize);
    Subject getById(String code);
    Subject getByName(String name);
    Subject create(Subject subject);
    Subject update(Subject subject);
    void delete(String code);
}
