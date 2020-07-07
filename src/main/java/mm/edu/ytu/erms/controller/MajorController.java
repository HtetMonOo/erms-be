package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Major;
import mm.edu.ytu.erms.repository.MajorRepository;
import mm.edu.ytu.erms.service.MajorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("major")
public class MajorController {
    @Autowired
    MajorService majorService;

    @GetMapping
    public List<Major> getAll(){
        return majorService.getAll();
    }

    @GetMapping("{code}")
    public Major getById(@PathVariable String code){
        return majorService.getByCode(code);
    }

    @PostMapping()
    public Major create(@RequestBody Major major){
        return majorService.create(major);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Major update(@RequestBody Major major){
        System.out.println("In controller");
        return majorService.update(major);
    }
    @RequestMapping( value = "{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String code){
        majorService.delete(code);
    }
}

