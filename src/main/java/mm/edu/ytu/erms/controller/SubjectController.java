package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Subject;
import mm.edu.ytu.erms.repository.SubjectRepository;
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
    SubjectRepository subjectRepository;

//    @GetMapping
//    public ResponseEntity<List<Subject>> getAll(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "10") Integer pageSize,
//            @RequestParam(defaultValue = "position") String sortBy)
//    {
//        List<Subject> list = subjectService.getAll(pageNo, pageSize);
//
//        return new ResponseEntity<List<Subject>>(list, new HttpHeaders(), HttpStatus.OK);
//    }

    @GetMapping
    public List<Subject> getSub(){
        return subjectRepository.findAll();
    }

    @GetMapping("code/{code}")
    public List<Subject> getAll(@PathVariable String code){
        Pageable page = PageRequest.of(0,10);
        List<Subject> allSubjects = subjectRepository.findByCodeContainsIgnoreCase(code, page);
        return allSubjects;
    }

    @GetMapping("{code}")
    public Subject getById(@PathVariable String code){
        return subjectRepository.getOne(code);
    }

    @GetMapping("name/{name}")
    public Subject getByName(@PathVariable String name){
        return subjectRepository.findByName(name);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject){
        return subjectRepository.saveAndFlush(subject);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Subject update(@RequestBody Subject subject){
        Subject oldData = subjectRepository.getOne(subject.getCode());
        BeanUtils.copyProperties(subject, oldData);
        return subjectRepository.saveAndFlush(oldData);
    }
    @RequestMapping( value = "{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String code){
        subjectRepository.deleteById(code);
    }
}
