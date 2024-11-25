package nuc.edu.cn.ljy.tesejavaeemvcmybatis.service;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.User;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    public int addUser(User user) {
        return userMapper.insert(user);
    }

    public int updateUser(User user) {
        return userMapper.update(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }
}