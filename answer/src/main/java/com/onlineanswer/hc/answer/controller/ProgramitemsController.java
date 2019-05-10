package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.service.ProgramitemsService;
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
public class ProgramitemsController {
    @Autowired
    private ProgramitemsService programitemsService;

    //分页查询
    @PostMapping("/getProgramitemsList")
    public R getProgramitemsList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=programitemsService.getProgramitemsList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addProgramitems")
    public String addProgramitems(Programitems programitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(programitemsService.insert(programitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delProgramitems")
    public String delProgramitems(Programitems programitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(programitemsService.deleteById(programitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateProgramitems")
    public String updateProgramitems(Programitems programitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(programitemsService.updateById(programitems)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询题目信息
    @PostMapping("/getProgramitemsById")
    public Programitems getProgramitemsById(Programitems programitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return programitemsService.selectOne(
                new EntityWrapper<Programitems>().eq("id",programitems.getId()));
    }






}
