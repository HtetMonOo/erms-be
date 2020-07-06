package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Department;
import mm.edu.ytu.erms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("{code}")
    public Department getByCode(@PathVariable String code){
        return departmentService.getByCode(code);
    }

    @PostMapping
    public Department save(@RequestBody Department department){
        return departmentService.save(department);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.DELETE)
    public void deleteByCode(@PathVariable String code){
        departmentService.deleteByCode(code);
    }
}
