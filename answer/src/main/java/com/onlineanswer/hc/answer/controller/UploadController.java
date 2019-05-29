package com.onlineanswer.hc.answer.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.onlineanswer.hc.answer.entity.Examinfo;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.entity.Trueorfalseitems;
import com.onlineanswer.hc.answer.service.ExaminfomanageService;
import com.onlineanswer.hc.answer.service.GapfillingitemsService;
import com.onlineanswer.hc.answer.service.ShortansweritemsService;
import com.onlineanswer.hc.answer.service.TrueorfalseitemsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.apache.commons.fileupload.disk.DiskFileItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private ExaminfomanageService examinfomanageService;
    @Autowired
    private GapfillingitemsService gapfillingitemsService;

    @Autowired
    private TrueorfalseitemsService trueorfalseitemsService;

    @Autowired
    private ShortansweritemsService shortansweritemsService;


    //上传excel到题库基本信息表 物理存储 建议不要用
    @PostMapping(value = "/uploadExcelToExamInfo")
    public Map<String, Object> uploadExcelToExamInfo(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 指定文件上传位置
        String uploadPath = request.getSession().getServletContext()
                .getRealPath("/excel/upload");
        String path = null;
        File saveFile = null;
        List<Examinfo> list = new ArrayList<Examinfo>();       //正常可插入数据
        List<Examinfo> repeatList = new ArrayList<Examinfo>();; //数据库中重复数据
        try {
            // 判断是否为空
            if (!file.isEmpty()) {
                saveFile = new File(uploadPath + File.separator + file.getOriginalFilename());
                // 自动创建目录
                FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
            }
            log.info("文件上传路径是:"+saveFile.getAbsolutePath());
            InputStream is = new FileInputStream(saveFile);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            Examinfo examinfo = null;
            //list = new ArrayList<Examinfo>();
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        examinfo = new Examinfo();
                        //1.读取excel中相关数据
                        HSSFCell examtypeid = hssfRow.getCell(0);
                        HSSFCell name = hssfRow.getCell(1);
                        HSSFCell a = hssfRow.getCell(2);
                        HSSFCell b = hssfRow.getCell(3);
                        HSSFCell c = hssfRow.getCell(4);
                        HSSFCell d = hssfRow.getCell(5);
                        HSSFCell correctanswer = hssfRow.getCell(6);
                        HSSFCell explaininfo = hssfRow.getCell(7);

                        //封装题库基本信息字段
                        Double c1 = Double.parseDouble((getValue(examtypeid)));
                        int a1 = c1.intValue();
                        Integer a2 = Integer.valueOf(a1);
                        examinfo.setExamtypeid(a2);
                        examinfo.setName(getValue(name));
                        examinfo.setA(getValue(a));
                        examinfo.setB(getValue(b));
                        examinfo.setC(getValue(c));
                        examinfo.setD(getValue(d));
                        examinfo.setCorrectanswer(getValue(correctanswer));
                        examinfo.setExplaininfo(getValue(explaininfo));

                        //判断数据是否在数据库中重复
                        List<Examinfo> l = examinfomanageService.selectList(new EntityWrapper<Examinfo>().eq("name",getValue(name)));
                        if (l.size()>0) {
                            repeatList.add(examinfo);
                        } else {
                            list.add(examinfo);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repeatDataList", repeatList);
        map.put("dataList", list);
        map.put("code", list.size()>0?"0":"1");
        log.info("----------->"+map);
        return map;
    }

    //上传excel到 选择题 题库基本信息表 IO流形式
    @PostMapping(value = "/uploadExcelToExamInfoByIO")
    public Map<String, Object> uploadExcelToExamInfoByIO(@RequestParam("file") MultipartFile file,
                                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //git测试
        List<Examinfo> list = new ArrayList<Examinfo>();       //正常可插入数据
        List<Examinfo> repeatList = new ArrayList<Examinfo>();; //数据库中重复数据
        try {
            InputStream is = file.getInputStream();
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            Examinfo examinfo = null;

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        examinfo = new Examinfo();
                        //1.读取excel中相关数据
                        HSSFCell examtypeid = hssfRow.getCell(0);
                        HSSFCell name = hssfRow.getCell(1);
                        HSSFCell a = hssfRow.getCell(2);
                        HSSFCell b = hssfRow.getCell(3);
                        HSSFCell c = hssfRow.getCell(4);
                        HSSFCell d = hssfRow.getCell(5);
                        HSSFCell correctanswer = hssfRow.getCell(6);
                        HSSFCell explaininfo = hssfRow.getCell(7);

                        //封装题库基本信息字段
                        Double c1 = Double.parseDouble((getValue(examtypeid)));
                        int a1 = c1.intValue();
                        Integer a2 = Integer.valueOf(a1);
                        examinfo.setExamtypeid(a2);
                        examinfo.setName(getValue(name));
                        examinfo.setA(getValue(a));
                        examinfo.setB(getValue(b));
                        examinfo.setC(getValue(c));
                        examinfo.setD(getValue(d));
                        examinfo.setCorrectanswer(getValue(correctanswer));
                        examinfo.setExplaininfo(getValue(explaininfo));

                        //判断数据是否在数据库中重复
                        //List<Examinfo> l = examinfomanageService.selectList(new EntityWrapper<Examinfo>().eq("name",getValue(name)));
                        Examinfo em=examinfomanageService.selectOne(new EntityWrapper<Examinfo>().eq("name",getValue(name)));
                        if (em!=null) {
                            repeatList.add(examinfo);
                        } else {
                            list.add(examinfo);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repeatDataList", repeatList);
        map.put("dataList", list);
        map.put("code", list.size()>0?"0":"1");
        log.info("----------->"+map);
        return map;
    }
    //Excel 选择题 数据添加
    @PostMapping(value = "/addExamInfoForExcel")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public String addExamInfoForExcel(String array, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Examinfo> list=JSON.parseArray(array,Examinfo.class);
        try {
            for (Examinfo examinfo : list) {
                examinfomanageService.insert(examinfo);
            }
            return "success";
        }catch (Exception e){
            return "error";
        }
    }



    //上传excel到 填空题 题库基本信息表 IO流形式
    @PostMapping(value = "/uploadExcelToGapfillingByIO")
    public Map<String, Object> uploadExcelToGapfillingByIO(@RequestParam("file") MultipartFile file,
                                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //git测试
        List<Gapfillingitems> list = new ArrayList<Gapfillingitems>();       //正常可插入数据
        List<Gapfillingitems> repeatList = new ArrayList<Gapfillingitems>();; //数据库中重复数据
        try {
            InputStream is = file.getInputStream();
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            Gapfillingitems gap = null;

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        gap = new Gapfillingitems();
                        //1.读取excel中相关数据
                        HSSFCell examtypeid = hssfRow.getCell(0);
                        HSSFCell description = hssfRow.getCell(1);
                        HSSFCell result = hssfRow.getCell(2);

                        //封装题库基本信息字段
                        Double c1 = Double.parseDouble((getValue(examtypeid)));
                        int a1 = c1.intValue();
                        Integer a2 = Integer.valueOf(a1);
                        gap.setExamtypeid(a2);
                        gap.setDescription(getValue(description));
                        gap.setResult(getValue(result));

                        //判断数据是否在数据库中重复
                        //List<Gapfillingitems> l = gapfillingitemsService.selectList(new EntityWrapper<Gapfillingitems>().eq("description",getValue(description)));
                        Gapfillingitems gp =gapfillingitemsService.selectOne(new EntityWrapper<Gapfillingitems>().eq("description",getValue(description)));
                        if (gp!=null) {
                            repeatList.add(gap);//重复数据
                        } else {
                            list.add(gap);//正常可用数据
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repeatDataList", repeatList);
        map.put("dataList", list);
        map.put("code", list.size()>0?"0":"1");
        log.info("----------->"+map);
        return map;
    }
    //Excel 填空题 数据添加
    @PostMapping(value = "/addGapfillingForExcel")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public String addGapfillingForExcel(String array, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Gapfillingitems> list=JSON.parseArray(array,Gapfillingitems.class);
        try {
            for (Gapfillingitems gap : list) {
                gapfillingitemsService.insert(gap);
            }
            return "success";
        }catch (Exception e){
            return "error";
        }
    }


    //上传excel到 判断题 题库基本信息表 IO流形式
    @PostMapping(value = "/uploadExcelToTrueorfalseByIO")
    public Map<String, Object> uploadExcelToTrueorfalseByIO(@RequestParam("file") MultipartFile file,
                                                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //git测试
        List<Trueorfalseitems> list = new ArrayList<Trueorfalseitems>();       //正常可插入数据
        List<Trueorfalseitems> repeatList = new ArrayList<Trueorfalseitems>();; //数据库中重复数据
        try {
            InputStream is = file.getInputStream();
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            Trueorfalseitems tof = null;

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        tof = new Trueorfalseitems();
                        //1.读取excel中相关数据
                        HSSFCell examtypeid = hssfRow.getCell(0);
                        HSSFCell description = hssfRow.getCell(1);
                        HSSFCell result = hssfRow.getCell(2);

                        //封装题库基本信息字段
                        Double c1 = Double.parseDouble((getValue(examtypeid)));
                        int a1 = c1.intValue();
                        Integer a2 = Integer.valueOf(a1);
                        tof.setExamtypeid(a2);
                        tof.setDescription(getValue(description));
                        tof.setResult(getValue(result));

                        //判断数据是否在数据库中重复
                        Trueorfalseitems tt =trueorfalseitemsService.selectOne(new EntityWrapper<Trueorfalseitems>().eq("description",getValue(description)));
                        if (tt!=null) {
                            repeatList.add(tof);//重复数据
                        } else {
                            list.add(tof);//正常可用数据
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repeatDataList", repeatList);
        map.put("dataList", list);
        map.put("code", list.size()>0?"0":"1");
        log.info("----------->"+map);
        return map;
    }
    //Excel 判断题 数据添加
    @PostMapping(value = "/addTrueorfalseForExcel")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public String addTrueorfalseForExcel(String array, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Trueorfalseitems> list=JSON.parseArray(array,Trueorfalseitems.class);
        try {
            for (Trueorfalseitems tt : list) {
                trueorfalseitemsService.insert(tt);
            }
            return "success";
        }catch (Exception e){
            return "error";
        }
    }


    //上传excel到 填空题 题库基本信息表 IO流形式
    @PostMapping(value = "/uploadExcelToShortanswerByIO")
    public Map<String, Object> uploadExcelToShortanswerByIO(@RequestParam("file") MultipartFile file,
                                                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //git测试
        List<Shortansweritems> list = new ArrayList<Shortansweritems>();       //正常可插入数据
        List<Shortansweritems> repeatList = new ArrayList<Shortansweritems>();; //数据库中重复数据
        try {
            InputStream is = file.getInputStream();
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            Shortansweritems sai = null;

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        sai = new Shortansweritems();
                        //1.读取excel中相关数据
                        HSSFCell examtypeid = hssfRow.getCell(0);
                        HSSFCell description = hssfRow.getCell(1);
                        HSSFCell result = hssfRow.getCell(2);

                        //封装题库基本信息字段
                        Double c1 = Double.parseDouble((getValue(examtypeid)));
                        int a1 = c1.intValue();
                        Integer a2 = Integer.valueOf(a1);
                        sai.setExamtypeid(a2);
                        sai.setDescription(getValue(description));
                        sai.setResult(getValue(result));

                        //判断数据是否在数据库中重复
                        //List<Gapfillingitems> l = gapfillingitemsService.selectList(new EntityWrapper<Gapfillingitems>().eq("description",getValue(description)));
                        Shortansweritems gp =shortansweritemsService.selectOne(new EntityWrapper<Shortansweritems>().eq("description",getValue(description)));
                        if (gp!=null) {
                            repeatList.add(sai);//重复数据
                        } else {
                            list.add(sai);//正常可用数据
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("repeatDataList", repeatList);
        map.put("dataList", list);
        map.put("code", list.size()>0?"0":"1");
        log.info("----------->"+map);
        return map;
    }
    //Excel 填空题 数据添加
    @PostMapping(value = "/addShortanswerForExcel")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public String addShortanswerForExcel(String array, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Shortansweritems> list=JSON.parseArray(array,Shortansweritems.class);
        try {
            for (Shortansweritems sai : list) {
                shortansweritemsService.insert(sai);
            }
            return "success";
        }catch (Exception e){
            return "error";
        }
    }













    /**
     * 判断excel数据类型
     * @param hssfCell
     * @return
     */
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }

    }
}
