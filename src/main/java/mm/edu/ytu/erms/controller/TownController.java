package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mm.edu.ytu.erms.model.Town;
import mm.edu.ytu.erms.service.TownService;

@RestController
@CrossOrigin
@RequestMapping("town")
public class TownController {
    @Autowired
    TownService townService;

    @GetMapping
    public List<Town> getAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize)
    {
        return townService.getAll(pageNo, pageSize);
    }

    @GetMapping("{pCode}")
    public Town getByCode(@PathVariable String pCode){
        return townService.getByPCode(pCode);
    }

    @PostMapping
    public Town save(@RequestBody Town Town){
        return townService.save(Town);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Town update(@RequestBody Town Town){
        return townService.update(Town);
    }

    @RequestMapping(value = "{pCode}", method = RequestMethod.DELETE)
    public void deleteByCode(@PathVariable String pCode){
        townService.deleteByPCode(pCode);
    }
}