package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 班级的service
 */
public interface ClassmanageService extends IService<Classinfo> {
    PageUtils getClassmanageList(Map<String, Object> params);
}
