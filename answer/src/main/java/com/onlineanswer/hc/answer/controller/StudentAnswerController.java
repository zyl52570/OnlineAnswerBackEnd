package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Studentsanswer;

import com.onlineanswer.hc.answer.service.StudentsAnswerService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class StudentAnswerController {
    @Autowired
    private StudentsAnswerService studentsAnswerService;
    //添加
    @PostMapping("/addStudentsanswer")
    public String addStudentsanswer(Studentsanswer Studentsanswer, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentsAnswerService.insert(Studentsanswer)){
            return "success";
        }else{
            return "error";
        }
    }
    //修改

    @PostMapping("/updateStudentsanswer")
    public String updateStudentsanswer(Studentsanswer Studentsanswer, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentsAnswerService.insertOrUpdate(Studentsanswer)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/deleteStudentsanswer")
    public String deleteStudentsanswer(Studentsanswer Studentsanswer, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(studentsAnswerService.deleteById(Studentsanswer)){
            return "success";
        }else{
            return "error";
        }
    }
    //分页查询
    @PostMapping("/selectStudentsanswer")
    public R selectStudentsanswer(@RequestParam Map<String, Object> map, HttpServletResponse response){
        System.out.println(map);
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=studentsAnswerService.getStudentsAnswerList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

}
