package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Department;
import mm.edu.ytu.erms.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    @Transactional
    @Override
    public Department getByCode(String code){
        return departmentRepository.getOne(code);
    }

    @Transactional
    @Override
    public Department save(Department department){
        return departmentRepository.saveAndFlush(department);
    }

    @Transactional
    @Override
    public Department update(Department department){
        Department oldDept = departmentRepository.getOne(department.getCode());
        BeanUtils.copyProperties(department, oldDept, "code", "dateCreated", "position");
        return departmentRepository.saveAndFlush(oldDept);
    }

    @Transactional
    @Override
    public void deleteByCode(String code){
        departmentRepository.deleteById(code);
    }
}