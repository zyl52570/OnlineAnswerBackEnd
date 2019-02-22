package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Sysuser;
import com.onlineanswer.hc.answer.service.SysuserService;
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
public class SysuserController {
    @Autowired
    private SysuserService sysuserService;
    //用户登录
    @PostMapping("/sysLogin")
    public Sysuser sysLogin(Sysuser sysuser, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Sysuser user=sysuserService.selectOne(new EntityWrapper<Sysuser>()
                .eq("login",sysuser.getLogin())
                .eq("pwd",sysuser.getPwd()));
        return user;
    }

    //分页查询
    @PostMapping("/getSysuserList")
    public R getSysuserList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=sysuserService.getSysuserList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addSysuser")
    public String addSysuser(Sysuser sysuser, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(sysuserService.insert(sysuser)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delSysuser")
    public String delSysuser(Sysuser sysuser, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(sysuserService.deleteById(sysuser)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateSysuser")
    public String updateSysuser(Sysuser sysuser, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(sysuserService.updateById(sysuser)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询信息
    @PostMapping("/getSysuserById")
    public Sysuser getSysuserById(Sysuser sysuser, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return sysuserService.selectOne(
                new EntityWrapper<Sysuser>().eq("id",sysuser.getId()));
    }

}
