package nuc.edu.cn.ljy.tesejavaeemvcmybatis.controller;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.User;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        try {
            model.addAttribute("users", userService.getAllUsers());
            return "user/list";
        } catch (Exception e) {
            e.printStackTrace();
            // 添加错误信息到模型
            model.addAttribute("error", "获取用户列表失败: " + e.getMessage());
            return "error";  // 创建一个错误页面
        }
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/form";
    }

    @PostMapping("/save")
    public String save(User user) {
        if (user.getId() == null) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
}