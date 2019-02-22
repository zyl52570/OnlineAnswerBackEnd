package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.StudentDao;
import com.onlineanswer.hc.answer.dao.SysuserDao;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.entity.Sysuser;
import com.onlineanswer.hc.answer.service.StudentService;
import com.onlineanswer.hc.answer.service.SysuserService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysuserService")
public class SysuserServiceImp extends ServiceImpl<SysuserDao, Sysuser> implements SysuserService {
    @Override
    public PageUtils getSysuserList(Map<String, Object> params) {
        Page<Sysuser> page=new Query<Sysuser>(params).getPage();
        List<Sysuser> list=baseMapper.getSysuserList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
