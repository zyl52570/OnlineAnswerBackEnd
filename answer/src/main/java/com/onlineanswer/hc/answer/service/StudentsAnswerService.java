package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * service
 */
public interface StudentsAnswerService extends IService<Studentsanswer> {
    PageUtils getStudentsAnswerList(Map<String, Object> params);
}
