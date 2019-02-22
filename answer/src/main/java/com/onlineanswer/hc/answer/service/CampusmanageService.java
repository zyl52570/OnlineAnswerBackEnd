package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 校区的service
 */
public interface CampusmanageService extends IService<Campusmanage> {
    PageUtils getCampusmanageList(Map<String, Object> params);
}
