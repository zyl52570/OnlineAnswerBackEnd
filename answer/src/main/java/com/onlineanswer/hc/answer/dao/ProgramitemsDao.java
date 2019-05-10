package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.answer.entity.Programitems;

import java.util.List;
import java.util.Map;

/**
 * 程序题dao
 */
public interface ProgramitemsDao extends BaseMapper<Programitems> {
    //多表联查方式
    List<Programitems> getProgramitemsList(Page<Programitems> page, Map<String, Object> params);
}
