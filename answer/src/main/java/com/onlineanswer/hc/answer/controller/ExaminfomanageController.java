package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Examinfo;
import com.onlineanswer.hc.answer.service.ExaminfomanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
public class ExaminfomanageController {
    @Autowired
    private ExaminfomanageService examinfomanageService;

    //分页查询
    @PostMapping("/getExaminfoList")
    public R getExaminfoList(@RequestParam Map<String, Object> map, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageUtils pu=examinfomanageService.getExaminfoList(map);
        return new R(0,"success",pu.getTotalCount(),pu.getList());
    }

    //添加
    @PostMapping("/addExaminfo")
    public String addExaminfo(Examinfo examinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examinfomanageService.insert(examinfo)){
            return "success";
        }else{
            return "error";
        }
    }

    //删除
    @PostMapping("/delExaminfo")
    public String delExaminfo(Examinfo examinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examinfomanageService.deleteById(examinfo)){
            return "success";
        }else{
            return "error";
        }
    }

    //修改
    @PostMapping("/updateExaminfo")
    public String updateExaminfo(Examinfo examinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(examinfomanageService.updateById(examinfo)){
            return "success";
        }else{
            return "error";
        }
    }
    //根据id查询题目信息
    @PostMapping("/getExaminfoById")
    public Examinfo getExaminfoById(Examinfo examinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return examinfomanageService.selectOne(
                new EntityWrapper<Examinfo>().eq("id",examinfo.getId()));
    }


    //根据题目类别id 随机选取20道题进行出题
    @PostMapping("/getExaminfoByTypeId")
    public List<Examinfo> getExaminfoByTypeId(Examinfo examinfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Examinfo> list;
        list= examinfomanageService.selectList(
                new EntityWrapper<Examinfo>().eq("examtypeid",examinfo.getExamtypeid()));
        if(list.size()<=20){
            //如果题库出题小于等于20题时则直接返回
            return list;
        }else{
            ArrayList<Integer> li=new ArrayList<>();
            do {
                int result = getRandomNum(list.size());
                if (!li.contains(result)) {
                    li.add(result);
                }
            }while (li.size()<20);
            List<Examinfo> list_new=new ArrayList<>();
            for (int i=0;i<li.size();i++){
                list_new.add(list.get(li.get(i)));
            }
            System.out.println(list_new.toString());
            return list_new;
        }
    }
    public static int getRandomNum(int count){
        Random random=new Random();
        return random.nextInt(count);
    }



}
