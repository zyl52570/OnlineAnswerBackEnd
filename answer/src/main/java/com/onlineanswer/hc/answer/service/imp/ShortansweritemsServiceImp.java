package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ProgramitemsDao;
import com.onlineanswer.hc.answer.dao.ShortansweritemsDao;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.entity.Shortansweritems;
import com.onlineanswer.hc.answer.service.ProgramitemsService;
import com.onlineanswer.hc.answer.service.ShortansweritemsService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shortansweritemsService")
public class ShortansweritemsServiceImp extends ServiceImpl<ShortansweritemsDao, Shortansweritems> implements ShortansweritemsService {
    @Override
    public PageUtils getShortansweritemsList(Map<String, Object> params) {
        Page<Shortansweritems> page=new Query<Shortansweritems>(params).getPage();
        List<Shortansweritems> list=baseMapper.getShortansweritemsList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
