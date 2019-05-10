package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 简答题service
 */
public interface GapfillingitemsService extends IService<Gapfillingitems> {
    PageUtils getGapfillingitemsList(Map<String, Object> params);
}
