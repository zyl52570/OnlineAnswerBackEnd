package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 学生service
 */
public interface StudentService extends IService<Student> {
    PageUtils getStudentList(Map<String, Object> params);
}
