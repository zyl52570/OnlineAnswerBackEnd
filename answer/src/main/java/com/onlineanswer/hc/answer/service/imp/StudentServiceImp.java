package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.ClassmanageDao;
import com.onlineanswer.hc.answer.dao.StudentDao;
import com.onlineanswer.hc.answer.entity.Classinfo;
import com.onlineanswer.hc.answer.entity.Student;
import com.onlineanswer.hc.answer.service.ClassmanageService;
import com.onlineanswer.hc.answer.service.StudentService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImp extends ServiceImpl<StudentDao, Student> implements StudentService {
    @Override
    public PageUtils getStudentList(Map<String, Object> params) {
        Page<Student> page=new Query<Student>(params).getPage();
        List<Student> list=baseMapper.getStudentList(page,params);
        page.setRecords(list);
        return new PageUtils(page);
    }

    @Override
    public List<Student> getStudentListByClassId(Map<String, Object> params) {
        return baseMapper.getStudentListByClassId(params);
    }
}
