package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.entity.Trueorfalseitems;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 简答题service
 */
public interface TrueorfalseitemsService extends IService<Trueorfalseitems> {
    PageUtils getTrueorfalseitemsList(Map<String, Object> params);
}
