package mm.edu.ytu.erms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mm.edu.ytu.erms.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
  
}