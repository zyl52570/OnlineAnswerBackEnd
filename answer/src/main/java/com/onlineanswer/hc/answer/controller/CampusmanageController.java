package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.service.CampusmanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class CampusmanageController {
    @Autowired
    private CampusmanageService campusmanageService;
    //添加
    @PostMapping("/addCampusmanage")
    public String addCampusmanage(Campusmanage campusmanage, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(campusmanageService.insert(campusmanage)){
            return "success";
        }else{
            return "error";
        }
    }
    //修改

    @PostMapping("/updateCampusmanage")
    public String updateCampusmanage(Campusmanage campusmanage, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        if(campusmanageService.insertOrUpdate(campusmanage)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/deleteCampusmanage")
    public String deleteCampusmanage(Campusmanage campusmanage, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(campusmanageService.deleteById(campusmanage)){
            return "success";
        }else{
            return "error";
        }
    }
    //分页查询
    @PostMapping("/selectCampusmanage")
    public R selectCampusmanage(@RequestParam Map<String, Object> map, HttpServletResponse response){
        System.out.println(map);
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=campusmanageService.getCampusmanageList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }
    //查询
    @PostMapping("/getCampusInfoById")
    public Campusmanage getCampusInfoById(Campusmanage campusmanage, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return campusmanageService.selectOne(
                new EntityWrapper<Campusmanage>().eq("id",campusmanage.getId()));
    }

    //获取校区所有数据 用于绑定下拉列表
    @PostMapping("/getAllCampusmanage")
    public List<Campusmanage> getAllCampusmanage( HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return campusmanageService.selectList(new EntityWrapper<Campusmanage>());
    }

}
