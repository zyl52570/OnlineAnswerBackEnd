package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.GapfillingitemsDao;
import com.onlineanswer.hc.answer.dao.ProgramitemsDao;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.answer.entity.Programitems;
import com.onlineanswer.hc.answer.service.GapfillingitemsService;
import com.onlineanswer.hc.answer.service.ProgramitemsService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("programitemsService")
public class ProgramitemsServiceImp extends ServiceImpl<ProgramitemsDao, Programitems> implements ProgramitemsService {
    @Override
    public PageUtils getProgramitemsList(Map<String, Object> params) {
        Page<Programitems> page=new Query<Programitems>(params).getPage();
        List<Programitems> list=baseMapper.getProgramitemsList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
