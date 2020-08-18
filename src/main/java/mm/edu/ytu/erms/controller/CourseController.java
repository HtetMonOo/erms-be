package mm.edu.ytu.erms.controller;

import mm.edu.ytu.erms.model.Course;
import mm.edu.ytu.erms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("{id}")
    public Course getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Integer id) {
        courseService.deleteById(id);
    }
}
