package nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();

    User selectById(Integer id);

    int insert(User user);

    int update(User user);

    int deleteById(Integer id);
}