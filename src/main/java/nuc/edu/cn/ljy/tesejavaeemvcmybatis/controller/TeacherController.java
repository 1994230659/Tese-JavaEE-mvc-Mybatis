package nuc.edu.cn.ljy.tesejavaeemvcmybatis.controller;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Teacher;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public String list(Model model) {
        try {
            model.addAttribute("teachers", teacherService.getAllTeachers());
            return "teacher/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "获取教师列表失败: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "teacher/form";
    }

    @PostMapping("/save")
    public String save(Teacher teacher) {
        if (teacher.getId() == null) {
            teacherService.addTeacher(teacher);
        } else {
            teacherService.updateTeacher(teacher);
        }
        return "redirect:/teacher/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/list";
    }

    @GetMapping("/courses/{id}")
    public String viewCourses(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherWithCourses(id));
        return "teacher/courses";
    }
}