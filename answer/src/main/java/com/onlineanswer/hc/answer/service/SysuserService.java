package com.onlineanswer.hc.answer.service;

import com.baomidou.mybatisplus.service.IService;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.entity.Sysuser;
import com.onlineanswer.hc.utils.PageUtils;

import java.util.Map;

/**
 * 后台管理service
 */
public interface SysuserService extends IService<Sysuser> {
    PageUtils getSysuserList(Map<String, Object> params);
}
