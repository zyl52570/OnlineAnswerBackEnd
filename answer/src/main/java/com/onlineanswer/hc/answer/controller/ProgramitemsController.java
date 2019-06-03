package com.onlineanswer.hc.answer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.service.ProgramitemsService;
import com.onlineanswer.hc.utils.DateUtils;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

@Slf4j
@RestController
public class ProgramitemsController {
    @Value("${filepath.uploadPathToPdf:#{null}}")
    private String uploadPathToPdf;

    @Value("${filepath.uploadPathToZip:#{null}}")
    private String uploadPathToZip;

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
    public String addProgramitems(HttpServletRequest request,Programitems programitems, HttpServletResponse response, MultipartFile file1, MultipartFile file2){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //uploadPathToPdf = request.getSession().getServletContext().getRealPath("/pdf/upload");
        //uploadPathToZip = request.getSession().getServletContext().getRealPath("/zip/upload");
        File saveFileToPdf = null;
        File saveFileToZip = null;
        try {
            // 判断是否为空
            if (!file1.isEmpty() && !file2.isEmpty()) {
                uploadPathToPdf=uploadPathToPdf + File.separator + DateUtils.getDateTime()+".pdf";
                saveFileToPdf = new File(uploadPathToPdf);

                // 自动创建目录
                FileUtils.copyInputStreamToFile(file1.getInputStream(), saveFileToPdf);
                log.info("文件上传路径是:"+saveFileToPdf.getAbsolutePath());
                uploadPathToZip=uploadPathToZip + File.separator + DateUtils.getDateTime()+".zip";
                saveFileToZip = new File(uploadPathToZip);
                // 自动创建目录
                FileUtils.copyInputStreamToFile(file1.getInputStream(), saveFileToZip);
                log.info("文件上传路径是:"+saveFileToZip.getAbsolutePath());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        //file1 ==>上传题目 原题
        //file2 ==>上传题目 答案
        programitems.setOriginalname(file1.getOriginalFilename());
        programitems.setFilename(file2.getOriginalFilename());
        programitems.setOriginalpath(uploadPathToPdf);
        programitems.setFilepath(uploadPathToZip);
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
