package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Classinfo;

import java.util.List;
import java.util.Map;

/**
 * 班级dao
 */
public interface ClassmanageDao extends BaseMapper<Classinfo> {
    //多表联查方式
    List<Classinfo> getClassmanageList(Page<Classinfo> page, Map<String, Object> params);
}
