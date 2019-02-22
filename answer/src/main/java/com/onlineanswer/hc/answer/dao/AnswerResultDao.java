package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Answerresult;
import com.onlineanswer.hc.answer.entity.Studentsanswer;

import java.util.List;
import java.util.Map;

/**
 * dao
 */
public interface AnswerResultDao extends BaseMapper<Answerresult> {
    //查询学生答题结果
    List<Answerresult> getAnswerresultList(Answerresult answerresult);
}
