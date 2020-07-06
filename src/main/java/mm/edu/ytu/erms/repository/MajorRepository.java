package mm.edu.ytu.erms.repository;

import mm.edu.ytu.erms.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
    public Major findByName(String name);
}
