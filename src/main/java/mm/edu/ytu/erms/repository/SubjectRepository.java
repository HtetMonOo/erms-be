package mm.edu.ytu.erms.repository;

import mm.edu.ytu.erms.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, String>, JpaRepository<Subject, String> {
    public Subject findByName(String name);
    List<Subject> findByCodeContains(String code);
}
