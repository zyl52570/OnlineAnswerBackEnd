package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 岗位的service
 */
public interface PostmanageService extends IService<CampusPostVo> {
    PageUtils getPostmanageList(Map<String, Object> params);
}
