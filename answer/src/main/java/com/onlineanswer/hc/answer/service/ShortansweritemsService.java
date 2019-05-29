package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 简答题service
 */
public interface ShortansweritemsService extends IService<Shortansweritems> {
    PageUtils getShortansweritemsList(Map<String, Object> params);
}
