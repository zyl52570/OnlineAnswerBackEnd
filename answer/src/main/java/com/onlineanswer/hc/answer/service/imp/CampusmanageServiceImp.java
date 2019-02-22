package com.onlineanswer.hc.answer.service.imp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.onlineanswer.hc.answer.dao.CampusmanageDao;
import com.onlineanswer.hc.answer.entity.Campusmanage;
import com.onlineanswer.hc.answer.service.CampusmanageService;
import com.onlineanswer.hc.utils.PageUtils;
import com.onlineanswer.hc.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("campusmanageService")
public class CampusmanageServiceImp extends ServiceImpl<CampusmanageDao, Campusmanage> implements CampusmanageService {
    @Override
    public PageUtils getCampusmanageList(Map<String, Object> params) {
        String name="";
        try{
            name=params.get("name").toString();
        }catch (Exception ex){
            name="";
        }
        Page<Campusmanage> page = this.selectPage(
                new Query<Campusmanage>(params).getPage(),
                new EntityWrapper<Campusmanage>().like("name",name)
        );
        return new PageUtils(page);
    }
}
