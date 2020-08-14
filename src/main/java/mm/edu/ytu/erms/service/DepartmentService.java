package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll(Integer pageNo, Integer pageSize);
    Department getByCode(String code);
    Department save(Department department);
    Department update(Department department);
    void deleteByCode(String code);
}