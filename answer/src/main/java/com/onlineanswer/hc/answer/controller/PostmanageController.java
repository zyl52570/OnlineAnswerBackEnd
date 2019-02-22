package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.entity.Postmanage;
import com.onlineanswer.hc.answer.service.CampusmanageService;
import com.onlineanswer.hc.answer.service.PostmanageService;
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
public class PostmanageController {
    @Autowired
    private PostmanageService postmanageService;

    //分页查询
    @PostMapping("/getPostmanageList")
    public R getPostmanageList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=postmanageService.getPostmanageList(map);
        log.info("数据是",pu.getList());
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addPostmanage")
    public String addPostmanage(CampusPostVo campusPostVo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(postmanageService.insert(campusPostVo)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delPostmanage")
    public String delPostmanage(CampusPostVo campusPostVo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(postmanageService.deleteById(campusPostVo)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updatePostmanage")
    public String updatePostmanage(CampusPostVo campusPostVo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(postmanageService.updateById(campusPostVo)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据岗位id查询岗位信息
    @PostMapping("/getPostInfoById")
    public CampusPostVo getPostInfoById(CampusPostVo campusPostVo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return postmanageService.selectOne(
                new EntityWrapper<CampusPostVo>().eq("id",campusPostVo.getId()));
    }
    //根据校区获取岗位相关列表
    @PostMapping("/getPostListById")
    public List<CampusPostVo> getPostListById(CampusPostVo campusPostVo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return postmanageService.selectList(new EntityWrapper<CampusPostVo>()
                .eq("campusid",campusPostVo.getCampusid()));
    }
}
