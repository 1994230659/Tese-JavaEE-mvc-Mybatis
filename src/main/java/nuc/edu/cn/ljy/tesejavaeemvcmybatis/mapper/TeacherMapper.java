package nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeacherMapper {
    List<Teacher> selectAll();
    Teacher selectById(Integer id);
    Teacher selectByIdWithCourses(Integer id);
    int insert(Teacher teacher);
    int update(Teacher teacher);
    int deleteById(Integer id);
}