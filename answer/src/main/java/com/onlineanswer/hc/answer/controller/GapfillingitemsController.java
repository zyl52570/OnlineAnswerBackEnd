package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.answer.service.GapfillingitemsService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
public class GapfillingitemsController {
    @Autowired
    private GapfillingitemsService gapfillingitemsService;

    //分页查询
    @PostMapping("/getGapfillingitemsList")
    public R getGapfillingitemsList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=gapfillingitemsService.getGapfillingitemsList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addGapfillingitems")
    public String addGapfillingitems(Gapfillingitems gapfillingitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(gapfillingitemsService.insert(gapfillingitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delGapfillingitems")
    public String delGapfillingitems(Gapfillingitems gapfillingitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(gapfillingitemsService.deleteById(gapfillingitems)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateGapfillingitems")
    public String updateGapfillingitems(Gapfillingitems gapfillingitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(gapfillingitemsService.updateById(gapfillingitems)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询题目信息
    @PostMapping("/getGapfillingitemsById")
    public Gapfillingitems getGapfillingitemsById(Gapfillingitems gapfillingitems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return gapfillingitemsService.selectOne(
                new EntityWrapper<Gapfillingitems>().eq("id",gapfillingitems.getId()));
    }






}
