package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ShortansweritemsDao;
import com.onlineanswer.hc.answer.dao.TrueorfalseitemsDao;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.entity.Trueorfalseitems;
import com.onlineanswer.hc.answer.service.ShortansweritemsService;
import com.onlineanswer.hc.answer.service.TrueorfalseitemsService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("trueorfalseitemsService")
public class TrueorfalseitemsServiceImp extends ServiceImpl<TrueorfalseitemsDao, Trueorfalseitems> implements TrueorfalseitemsService {
    @Override
    public PageUtils getTrueorfalseitemsList(Map<String, Object> params) {
        Page<Trueorfalseitems> page=new Query<Trueorfalseitems>(params).getPage();
        List<Trueorfalseitems> list=baseMapper.getTrueorfalseitemsList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
