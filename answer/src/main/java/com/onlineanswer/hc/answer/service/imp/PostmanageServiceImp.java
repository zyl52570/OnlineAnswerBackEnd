package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.CampusmanageDao;
import com.onlineanswer.hc.answer.dao.PostmanageDao;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Postmanage;
import com.onlineanswer.hc.answer.service.CampusmanageService;
import com.onlineanswer.hc.answer.service.PostmanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("postmanageService")
public class PostmanageServiceImp extends ServiceImpl<PostmanageDao, CampusPostVo> implements PostmanageService {
    @Override
    public PageUtils getPostmanageList(Map<String, Object> params) {
        Page<CampusPostVo> page=new Query<CampusPostVo>(params).getPage();
        List<CampusPostVo> list=baseMapper.getPostmanageList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
