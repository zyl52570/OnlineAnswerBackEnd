package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.service.StudentService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //分页查询
    @PostMapping("/getStudentList")
    public R getStudentList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=studentService.getStudentList(map);
        log.info("数据是",pu.getList());
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addStudent")
    public String addStudent(Student student, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentService.insert(student)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delStudent")
    public String delStudent(Student student, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentService.deleteById(student)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateStudent")
    public String updateStudent(Student student, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentService.updateById(student)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询信息
    @PostMapping("/getStudentById")
    public Student getStudentById(Student student, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.selectOne(
                new EntityWrapper<Student>().eq("id",student.getId()));
    }

    //学生端登录
    @PostMapping("/studentLogin")
    public Student studentLogin(Student student, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.selectOne(
                new EntityWrapper<Student>()
                        .eq("login",student.getLogin())
                        .eq("pwd",student.getPwd()));
    }

}
