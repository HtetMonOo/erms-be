package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(Integer id);
    Course create(Course course);
    Course update(Course course);
    void deleteById(Integer id);
}
