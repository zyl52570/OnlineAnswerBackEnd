package com.onlineanswer.hc.answer.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Postmanage;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 校区dao
 */
public interface PostmanageDao extends BaseMapper<CampusPostVo> {
    //多表联查方式
    List<CampusPostVo> getPostmanageList(Page<CampusPostVo> page, Map<String, Object> params);
}
