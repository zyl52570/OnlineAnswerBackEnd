package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.entity.Shortansweritems;

import java.util.List;
import java.util.Map;

/**
 * 简答题dao
 */
public interface ShortansweritemsDao extends BaseMapper<Shortansweritems> {
    //多表联查方式
    List<Shortansweritems> getShortansweritemsList(Page<Shortansweritems> page, Map<String, Object> params);
}
