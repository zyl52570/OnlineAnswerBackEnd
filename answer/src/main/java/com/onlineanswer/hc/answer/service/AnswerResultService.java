package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Answerresult;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * service
 */
public interface AnswerResultService extends IService<Answerresult> {
    //查询学生答题结果
    List<Answerresult> getAnswerresultList(Answerresult answerresult);
}
