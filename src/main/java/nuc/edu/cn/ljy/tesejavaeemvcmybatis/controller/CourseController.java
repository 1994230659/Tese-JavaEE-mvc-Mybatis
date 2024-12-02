package nuc.edu.cn.ljy.tesejavaeemvcmybatis.controller;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Course;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.service.CourseService;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public String list(Model model) {
        try {
            model.addAttribute("courses", courseService.getAllCourses());
            return "course/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "获取课程列表失败: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "course/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "course/form";
    }

    @PostMapping("/save")
    public String save(Course course) {
        if (course.getId() == null) {
            courseService.addCourse(course);
        } else {
            courseService.updateCourse(course);
        }
        return "redirect:/course/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }

    @GetMapping("/students/{id}")
    public String viewStudents(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getCourseWithStudents(id));
        return "course/students";
    }
}