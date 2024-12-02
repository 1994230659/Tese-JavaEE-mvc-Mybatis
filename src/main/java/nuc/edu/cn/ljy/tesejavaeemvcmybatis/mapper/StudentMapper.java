package nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
    Student selectById(Integer id);
    Student selectByIdWithCourses(Integer id);
    int insert(Student student);
    int update(Student student);
    int deleteById(Integer id);
}