package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    Page<Subject> getAll(Pageable page);
    List<Subject> getSome(String code);
    Subject getByCode(String code);
    Subject getByName(String name);
    Subject create(Subject subject);
    Subject update(Subject subject);
    void delete(String code);
}
