package nuc.edu.cn.ljy.tesejavaeemvcmybatis.service;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Course;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getAllCourses() {
        return courseMapper.selectAll();
    }

    public Course getCourseById(Integer id) {
        return courseMapper.selectById(id);
    }

    public Course getCourseWithStudents(Integer id) {
        return courseMapper.selectByIdWithStudents(id);
    }

    public Course getCourseWithTeacher(Integer id) {
        return courseMapper.selectByIdWithTeacher(id);
    }

    public int addCourse(Course course) {
        return courseMapper.insert(course);
    }

    public int updateCourse(Course course) {
        return courseMapper.update(course);
    }

    public int deleteCourse(Integer id) {
        return courseMapper.deleteById(id);
    }
}