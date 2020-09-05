package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import cn.doeon.farm.shop.dao.ScienceActivityPraiseMapper;
import cn.doeon.farm.shop.service.ScienceActivityPraiseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceActivityPraiseServiceImpl extends ServiceImpl<ScienceActivityPraiseMapper, ActivityPraise> implements ScienceActivityPraiseService {
    @Autowired
    private ScienceActivityPraiseMapper scienceActivityPraiseMapper;

    @Override
    public String getActivityPraiseInfo(String activityId, String userId) {
        return scienceActivityPraiseMapper.getActivityPraiseInfo(activityId, userId);
    }
}
