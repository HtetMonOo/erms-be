package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Subject;
import mm.edu.ytu.erms.repository.SubjectRepository;
import mm.edu.ytu.erms.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    private Pageable page = PageRequest.of(0,10);

    @GetMapping()
    public Page<Subject> getTopSubjects(){
        return subjectService.getAll(page);
    }

    @GetMapping("{code}")
    public List<Subject> getSome(@PathVariable String code){
        return subjectService.getSome(code);
    }

    @GetMapping("code/{code}")
    public Subject getById(@PathVariable String code){
        return subjectService.getByCode(code);
    }

    @GetMapping("name/{name}")
    public Subject getByName(@PathVariable String name){
        return subjectService.getByName(name);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject){
        return subjectService.create(subject);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Subject update(@RequestBody Subject subject){
        return subjectService.update(subject);
    }
    @RequestMapping( value = "{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String code){
        subjectService.delete(code);
    }
}
