package mm.edu.ytu.erms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mm.edu.ytu.erms.model.Classes;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
	
}