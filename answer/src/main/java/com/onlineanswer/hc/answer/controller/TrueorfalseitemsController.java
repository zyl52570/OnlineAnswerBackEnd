package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Trueorfalseitems;
import com.onlineanswer.hc.answer.service.TrueorfalseitemsService;
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
public class TrueorfalseitemsController {
    @Autowired
    private TrueorfalseitemsService trueorfalseitemsService;

    //分页查询
    @PostMapping("/getTrueorfalseitemsList")
    public R getTrueorfalseitemsList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=trueorfalseitemsService.getTrueorfalseitemsList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addTrueorfalseitems")
    public String addTrueorfalseitems(Trueorfalseitems trueorfalseitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(trueorfalseitemsService.insert(trueorfalseitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delTrueorfalseitems")
    public String delTrueorfalseitems(Trueorfalseitems trueorfalseitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(trueorfalseitemsService.deleteById(trueorfalseitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateTrueorfalseitems")
    public String updateTrueorfalseitems(Trueorfalseitems trueorfalseitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(trueorfalseitemsService.updateById(trueorfalseitems)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询题目信息
    @PostMapping("/getTrueorfalseitemsById")
    public Trueorfalseitems getTrueorfalseitemsById(Trueorfalseitems trueorfalseitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return trueorfalseitemsService.selectOne(
                new EntityWrapper<Trueorfalseitems>().eq("id",trueorfalseitems.getId()));
    }






}
