package nuc.edu.cn.ljy.tesejavaeemvcmybatis.controller;

import nuc.edu.cn.ljy.tesejavaeemvcmybatis.entity.Student;
import nuc.edu.cn.ljy.tesejavaeemvcmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String list(Model model) {
        try {
            model.addAttribute("students", studentService.getAllStudents());
            return "student/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "获取学生列表失败: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/form";
    }

    @PostMapping("/save")
    public String save(Student student) {
        if (student.getId() == null) {
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

    @GetMapping("/courses/{id}")
    public String viewCourses(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentWithCourses(id));
        return "student/courses";
    }
}