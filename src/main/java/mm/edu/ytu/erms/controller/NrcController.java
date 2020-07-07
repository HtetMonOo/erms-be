package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.Nrc;
import mm.edu.ytu.erms.service.NrcService;

@RestController
@CrossOrigin
@RequestMapping("nrc")
public class NrcController {
    @Autowired
    NrcService nrcService;

    @GetMapping
    public List<Nrc> getAll(){
        return nrcService.getAll();
    }

    @GetMapping("{code}")
    public Nrc getByCode(@PathVariable String code){
        return nrcService.getByCode(code);
    }

    @PostMapping
    public Nrc save(@RequestBody Nrc nrc){
        return nrcService.save(nrc);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Nrc update(@RequestBody Nrc nrc){
        return nrcService.update(nrc);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.DELETE)
    public void deleteByCode(@PathVariable String code){
        nrcService.deleteByCode(code);
    }
}