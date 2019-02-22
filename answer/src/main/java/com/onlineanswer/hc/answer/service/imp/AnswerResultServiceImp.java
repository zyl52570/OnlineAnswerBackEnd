package com.onlineanswer.hc.answer.service.imp;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.AnswerResultDao;
import com.onlineanswer.hc.answer.dao.StudentsAnswerDao;
import com.onlineanswer.hc.answer.entity.Answerresult;
import com.onlineanswer.hc.answer.entity.Studentsanswer;
import com.onlineanswer.hc.answer.service.AnswerResultService;
import com.onlineanswer.hc.answer.service.StudentsAnswerService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("answerResultService")
public class AnswerResultServiceImp extends ServiceImpl<AnswerResultDao, Answerresult> implements AnswerResultService {
    @Override
    public List<Answerresult> getAnswerresultList(Answerresult answerresult) {
        return this.baseMapper.getAnswerresultList(answerresult);
    }
}
