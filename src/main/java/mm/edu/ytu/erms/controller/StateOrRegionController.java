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

import mm.edu.ytu.erms.model.StateOrRegion;
import mm.edu.ytu.erms.service.StateOrRegionService;

@RestController
@CrossOrigin
@RequestMapping("stateOrRegion")
public class StateOrRegionController {
    @Autowired
    StateOrRegionService stateOrRegionService;

    @GetMapping
    public List<StateOrRegion> getAll(){
        return stateOrRegionService.getAll();
    }

    @GetMapping("{id}")
    public StateOrRegion getById(@PathVariable Integer id){
        return stateOrRegionService.getById(id);
    }

    @PostMapping
    public StateOrRegion save(@RequestBody StateOrRegion StateOrRegion){
        return stateOrRegionService.save(StateOrRegion);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public StateOrRegion update(@RequestBody StateOrRegion StateOrRegion){
        return stateOrRegionService.update(StateOrRegion);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteByCode(@PathVariable Integer id){
        stateOrRegionService.deleteById(id);
    }
}