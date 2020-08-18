package mm.edu.ytu.erms.service;

import mm.edu.ytu.erms.model.Course;
import mm.edu.ytu.erms.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Integer id) {
        return courseRepository.getOne(id);
    }

    @Override
    public Course create(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public Course update(Course course) {
        Course oldCourse = courseRepository.getOne(course.getId());
        BeanUtils.copyProperties(course, oldCourse, "id");
        return courseRepository.saveAndFlush(oldCourse);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}
