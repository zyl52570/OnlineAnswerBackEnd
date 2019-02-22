package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ExaminfomanageDao;
import com.onlineanswer.hc.answer.dao.PostmanageDao;
import com.onlineanswer.hc.answer.entity.CampusPostVo;
import com.onlineanswer.hc.answer.entity.Examinfo;
import com.onlineanswer.hc.answer.service.ExaminfomanageService;
import com.onlineanswer.hc.answer.service.PostmanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("examinfomanageService")
public class ExaminfomanageServiceImp extends ServiceImpl<ExaminfomanageDao, Examinfo> implements ExaminfomanageService {
    @Override
    public PageUtils getExaminfoList(Map<String, Object> params) {
        Page<Examinfo> page=new Query<Examinfo>(params).getPage();
        List<Examinfo> list=baseMapper.getExaminfoList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
