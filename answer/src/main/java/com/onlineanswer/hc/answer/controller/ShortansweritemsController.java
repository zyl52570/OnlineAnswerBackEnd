package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.service.ShortansweritemsService;
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
public class ShortansweritemsController {
    @Autowired
    private ShortansweritemsService shortansweritemsService;

    //分页查询
    @PostMapping("/getShortansweritemsList")
    public R getShortansweritemsList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=shortansweritemsService.getShortansweritemsList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addShortansweritems")
    public String addShortansweritems(Shortansweritems shortansweritems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(shortansweritemsService.insert(shortansweritems)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delShortansweritems")
    public String delShortansweritems(Shortansweritems shortansweritems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(shortansweritemsService.deleteById(shortansweritems)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateShortansweritems")
    public String updateShortansweritems(Shortansweritems shortansweritems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(shortansweritemsService.updateById(shortansweritems)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询题目信息
    @PostMapping("/getShortansweritemsById")
    public Shortansweritems getShortansweritemsById(Shortansweritems shortansweritems, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return shortansweritemsService.selectOne(
                new EntityWrapper<Shortansweritems>().eq("id",shortansweritems.getId()));
    }






}
