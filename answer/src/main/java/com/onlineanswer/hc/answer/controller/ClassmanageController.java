package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.service.ClassmanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ClassmanageController {
    @Autowired
    private ClassmanageService classmanageService;

    //分页查询
    @PostMapping("/getClassmanageList")
    public R getPostmanageList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=classmanageService.getClassmanageList(map);
        log.info("数据是",pu.getList());
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addClassmanage")
    public String addClassmanage(Classinfo classinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(classmanageService.insert(classinfo)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delClassmanage")
    public String delClassmanage(Classinfo classinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(classmanageService.deleteById(classinfo)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateClassmanage")
    public String updateClassmanage(Classinfo classinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(classmanageService.updateById(classinfo)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询信息
    @PostMapping("/getClassInfoById")
    public Classinfo getClassInfoById(Classinfo classinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return classmanageService.selectOne(
                new EntityWrapper<Classinfo>().eq("id",classinfo.getId()));
    }

    //根据校区获取班级相关列表
    @PostMapping("/getClassListById")
    public List<Classinfo> getAllClassInfo(Classinfo classinfo,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return classmanageService.selectList(new EntityWrapper<Classinfo>()
                .eq("campusid",classinfo.getCampusid()));
    }
}
