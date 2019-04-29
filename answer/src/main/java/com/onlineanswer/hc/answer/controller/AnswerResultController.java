package com.onlineanswer.hc.answer.controller;

import com.onlineanswer.hc.answer.entity.Answerresult;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.answer.service.AnswerResultService;
import com.onlineanswer.hc.answer.service.StudentsAnswerService;
import com.onlineanswer.hc.utils.DateUtils;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerResultController {
    @Autowired
    private AnswerResultService answerResultService;
    @Autowired
    private StudentsAnswerService studentsAnswerService;

    //根据查询条件查询该学生答题结果
    @PostMapping("/getAnswerresultList")
    public List<Answerresult> getAnswerresultList(Answerresult answerresult, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Answerresult> list=answerResultService.getAnswerresultList(answerresult);
        return list;
    }

    @PostMapping("/addExamResult")
    @Transactional()
    public Map<String,Object>  addExamResult(@RequestParam Map<String,Object> params, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        String[] examid = params.get("examid").toString().split(",");
        String[] a = params.get("a").toString().split(",");
        String[] b = params.get("b").toString().split(",");
        String[] c = params.get("c").toString().split(",");
        String[] d = params.get("d").toString().split(",");
        String[] correctanswer = params.get("correctanswer").toString().split(",");
        String examtypeid = params.get("examtypeid").toString();
        String studentid = params.get("studentid").toString();
        String examinfoname = params.get("examinfoname").toString();

        String[] studentanswer = params.get("studentanswer").toString().split(",");
        Double trueNum = getTrueNum(examid,studentanswer,correctanswer);
        Integer grade=(int)((trueNum/examid.length)*100);//计算成绩百 分比

        Date createtime=new Date();

        //1.添加答题主表
        Studentsanswer ss=new Studentsanswer();
        ss.setExamtypeid(Integer.valueOf(examtypeid));
        ss.setStudentid(Integer.valueOf(studentid));
        ss.setGrade(grade);
        ss.setCreatetime(createtime);
        studentsAnswerService.insert(ss);
        System.out.println("新增后主表ID="+ss.getId());
        //2.添加答题详细表
        Integer ssid=ss.getId();

        for (int i=0;i<examid.length;i++){
            Answerresult as=new Answerresult();
            as.setSsid(ssid);
            as.setStudentid(Integer.valueOf(studentid));
            as.setExamid(Integer.valueOf(examid[i]));
            as.setA(a[i]);
            as.setB(b[i]);
            as.setC(c[i]);
            as.setD(d[i]);
            as.setStudentanswer(studentanswer[i].replace("0",""));
            as.setCorrectanswer(correctanswer[i]);
            as.setIstrue(studentanswer[i].equals(correctanswer[i])==true?"1":"0");
            as.setCreatetime(createtime);
            answerResultService.insert(as);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("ssid",ssid);
        map.put("studentid",studentid);
        map.put("examinfoname",examinfoname);
        map.put("grade",grade);
        map.put("createtime",createtime);
        return map;
    }

    public Double getTrueNum(String[] examid,String[] studentanswer,String[] correctanswer){
        Double count=0.0;
        for (int i=0;i<examid.length;i++){
            if(studentanswer[i].replace("0","").equals(correctanswer[i])){
                count++;
            }
        }
        return count;
    }
}
