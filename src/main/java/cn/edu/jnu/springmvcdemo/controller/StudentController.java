package cn.edu.jnu.springmvcdemo.controller;

import cn.edu.jnu.springmvcdemo.dao.StudentDao;
import cn.edu.jnu.springmvcdemo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 为简化流程，Controller直接调用Dao层数据，真实开发中不应这样做
 */
@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/stus")
    public String list(Model model) {
        List<Student> students = studentDao.selectList(null);
        model.addAttribute("stus", students);
        return "stu/list";
    }

    @GetMapping("/addStu")
    public String toAddStudent() {
        return "stu/add";
    }

    @PostMapping("/addStu")
    public String addStudent(Student student) {
        System.out.println("student = " + student);
        studentDao.insert(student);
        return "redirect:/stus";
    }

    @GetMapping("/toUpdateStu")
    public String toUpdateStudent(@RequestParam("id") Integer id, Model model) {
        Student student = studentDao.selectById(id);
        model.addAttribute("stu", student);
        return "stu/update";
    }

    @PostMapping("/updateStu")
    public String updateStu(Student student) {
        System.out.println("student = " + student);
        studentDao.updateById(student);
        return "redirect:/stus";
    }

    @GetMapping("/deleteStu")
    public String deleteStu(@RequestParam("id") Integer id) {
        studentDao.deleteById(id);
        return "redirect:/stus";
    }
}
