package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ClassmanageDao;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.service.ClassmanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("classmanageService")
public class ClassmanageServiceImp extends ServiceImpl<ClassmanageDao, Classinfo> implements ClassmanageService {
    @Override
    public PageUtils getClassmanageList(Map<String, Object> params) {
        Page<Classinfo> page=new Query<Classinfo>(params).getPage();
        List<Classinfo> list=baseMapper.getClassmanageList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
