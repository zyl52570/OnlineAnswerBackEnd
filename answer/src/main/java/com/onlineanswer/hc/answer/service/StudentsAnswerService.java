package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.utils.PageUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * service
 */
public interface StudentsAnswerService extends IService<Studentsanswer> {
    PageUtils getStudentsAnswerList(Map<String, Object> params);

    //根据学生查询该学生考试成绩图表
    List<Studentsanswer> getStatisticsEchart(Map<String, Object> map);
}
