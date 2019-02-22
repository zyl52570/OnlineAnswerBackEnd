package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Examinfo;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 题目service
 */
public interface ExaminfomanageService extends IService<Examinfo> {
    PageUtils getExaminfoList(Map<String, Object> params);
}
