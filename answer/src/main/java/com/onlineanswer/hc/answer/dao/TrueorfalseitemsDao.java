package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.entity.Trueorfalseitems;

import java.util.List;
import java.util.Map;

/**
 * 简答题dao
 */
public interface TrueorfalseitemsDao extends BaseMapper<Trueorfalseitems> {
    //多表联查方式
    List<Trueorfalseitems> getTrueorfalseitemsList(Page<Trueorfalseitems> page, Map<String, Object> params);
}
