package nuc.edu.cn.ljy.tesejavaeemvcmybatis.service;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Teacher;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAll();
    }

    public Teacher getTeacherById(Integer id) {
        return teacherMapper.selectById(id);
    }

    public Teacher getTeacherWithCourses(Integer id) {
        return teacherMapper.selectByIdWithCourses(id);
    }

    public int addTeacher(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    public int updateTeacher(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    public int deleteTeacher(Integer id) {
        return teacherMapper.deleteById(id);
    }
}