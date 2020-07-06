package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Major;
import mm.edu.ytu.erms.repository.MajorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("major")
public class MajorController {
    @Autowired
    MajorRepository majorRepository;

    @GetMapping
    public List<Major> getAll(){
        return majorRepository.findAll();
    }

    @GetMapping("{code}")
    public Major getById(@PathVariable String code){
        return majorRepository.getOne(code);
    }

    @GetMapping("name/{name}")
    public Major getByName(@PathVariable String name){
        return majorRepository.findByName(name);
    }

    @PostMapping()
    public Major save(@RequestBody Major major){
        return majorRepository.saveAndFlush(major);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Major update(@RequestBody Major major){
        Major oldData = majorRepository.getOne(major.getCode());
        BeanUtils.copyProperties(major, oldData);
        return majorRepository.saveAndFlush(oldData);
    }
    @RequestMapping( value = "{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String code){
        majorRepository.deleteById(code);
    }
}

