package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.CampusmanageDao;
import com.onlineanswer.hc.answer.dao.ExamtypeDao;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.entity.Examtype;
import com.onlineanswer.hc.answer.service.CampusmanageService;
import com.onlineanswer.hc.answer.service.ExamtypeService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("examtypeService")
public class ExamtypeServiceImp extends ServiceImpl<ExamtypeDao, Examtype> implements ExamtypeService {
    @Override
    public PageUtils getExamtypeList(Map<String, Object> params) {
        String name="";
        try{
            name=params.get("name").toString();
        }catch (Exception ex){
            name="";
        }
        Page<Examtype> page = this.selectPage(
                new Query<Examtype>(params).getPage(),
                new EntityWrapper<Examtype>().like("name",name)
        );
        return new PageUtils(page);
    }
}
