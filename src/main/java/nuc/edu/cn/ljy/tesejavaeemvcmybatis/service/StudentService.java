package nuc.edu.cn.ljy.tesejavaeemvcmybatis.service;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Student;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    public Student getStudentById(Integer id) {
        return studentMapper.selectById(id);
    }

    public Student getStudentWithCourses(Integer id) {
        return studentMapper.selectByIdWithCourses(id);
    }

    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.update(student);
    }

    public int deleteStudent(Integer id) {
        return studentMapper.deleteById(id);
    }
}