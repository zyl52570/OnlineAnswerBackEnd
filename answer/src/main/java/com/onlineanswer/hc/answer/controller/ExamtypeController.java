package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Examtype;

import com.onlineanswer.hc.answer.service.ExamtypeService;
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
public class ExamtypeController {
    @Autowired
    private ExamtypeService examtypeService;
    //添加
    @PostMapping("/addexamtype")
    public String addexamtype(Examtype examtype, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examtypeService.insert(examtype)){
            return "success";
        }else{
            return "error";
        }
    }
    //修改

    @PostMapping("/updateexamtype")
    public String updateexamtype(Examtype examtype, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examtypeService.insertOrUpdate(examtype)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/deleteexamtype")
    public String deleteexamtype(Examtype examtype, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examtypeService.deleteById(examtype)){
            return "success";
        }else{
            return "error";
        }
    }
    //分页查询
    @PostMapping("/selectexamtype")
    public R selectexamtype(@RequestParam Map<String, Object> map, HttpServletResponse response){
        System.out.println(map);
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=examtypeService.getExamtypeList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }
    //查询
    @PostMapping("/getExamtypeInfoById")
    public Examtype getExamtypeInfoById(Examtype examtype, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return examtypeService.selectOne(
                new EntityWrapper<Examtype>().eq("id",examtype.getId()));
    }

    //获取题目所有数据 用于绑定下拉列表
    @PostMapping("/getAllexamtype")
    public List<Examtype> getAllexamtype( HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return examtypeService.selectList(new EntityWrapper<Examtype>());
    }

}
