package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 校区dao
 */
public interface CampusmanageDao extends BaseMapper<Campusmanage> {
    PageUtils getCampusmanageList(Map<String, Object> params);
}
