package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ExaminfomanageDao;
import com.onlineanswer.hc.answer.dao.GapfillingitemsDao;
import com.onlineanswer.hc.answer.entity.Examinfo;
import com.onlineanswer.hc.answer.entity.Gapfillingitems;
import com.onlineanswer.hc.answer.service.ExaminfomanageService;
import com.onlineanswer.hc.answer.service.GapfillingitemsService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("gapfillingitemsService")
public class GapfillingitemsServiceImp extends ServiceImpl<GapfillingitemsDao, Gapfillingitems> implements GapfillingitemsService {
    @Override
    public PageUtils getGapfillingitemsList(Map<String, Object> params) {
        Page<Gapfillingitems> page=new Query<Gapfillingitems>(params).getPage();
        List<Gapfillingitems> list=baseMapper.getGapfillingitemsList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
