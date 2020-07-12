package mm.edu.ytu.erms.repository;

import mm.edu.ytu.erms.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, String> {
    public Subject findByName(String name);
}
