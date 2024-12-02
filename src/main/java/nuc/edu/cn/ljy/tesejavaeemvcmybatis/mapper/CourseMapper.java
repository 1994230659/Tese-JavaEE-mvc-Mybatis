package nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> selectAll();
    Course selectById(Integer id);
    Course selectByIdWithTeacher(Integer id);
    Course selectByIdWithStudents(Integer id);
    int insert(Course course);
    int update(Course course);
    int deleteById(Integer id);
}