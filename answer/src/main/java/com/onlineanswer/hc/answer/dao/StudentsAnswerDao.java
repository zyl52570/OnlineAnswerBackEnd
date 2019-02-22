package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * dao
 */
public interface StudentsAnswerDao extends BaseMapper<Studentsanswer> {
    //多表联查方式
    List<Studentsanswer> getStudentsAnswerList(Page<Studentsanswer> page, Map<String, Object> params);
}
