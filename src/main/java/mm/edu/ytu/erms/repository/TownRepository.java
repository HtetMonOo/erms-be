package mm.edu.ytu.erms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mm.edu.ytu.erms.model.Town;

@Repository
public interface TownRepository extends JpaRepository<Town,String>{
    
}