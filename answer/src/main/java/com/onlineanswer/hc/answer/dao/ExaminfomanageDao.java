package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Examinfo;

import java.util.List;
import java.util.Map;

/**
 * 校区dao
 */
public interface ExaminfomanageDao extends BaseMapper<Examinfo> {
    //多表联查方式
    List<Examinfo> getExaminfoList(Page<Examinfo> page, Map<String, Object> params);
}
