package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Examtype;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 题目类型的service
 */
public interface ExamtypeService extends IService<Examtype> {
    PageUtils getExamtypeList(Map<String, Object> params);
}
