package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.entity.Sysuser;

import java.util.List;
import java.util.Map;

/**
 * 学生dao
 */
public interface SysuserDao extends BaseMapper<Sysuser> {
    //多表联查方式
    List<Sysuser> getSysuserList(Page<Sysuser> page, Map<String, Object> params);
}
