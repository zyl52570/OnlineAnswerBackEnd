package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;

import java.util.List;
import java.util.Map;

/**
 * 填空题dao
 */
public interface GapfillingitemsDao extends BaseMapper<Gapfillingitems> {
    //多表联查方式
    List<Gapfillingitems> getGapfillingitemsList(Page<Gapfillingitems> page, Map<String, Object> params);
}
