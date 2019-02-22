package com.onlineanswer.hc.answer.service.imp;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.onlineanswer.hc.answer.dao.StudentsAnswerDao;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.answer.service.StudentsAnswerService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentsAnswerService")
public class StudentsAnswerServiceImp extends ServiceImpl<StudentsAnswerDao, Studentsanswer> implements StudentsAnswerService {
    @Override
    public PageUtils getStudentsAnswerList(Map<String, Object> params) {
        Page<Studentsanswer> page=new Query<Studentsanswer>(params).getPage();
        List<Studentsanswer> list=baseMapper.getStudentsAnswerList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }
}
