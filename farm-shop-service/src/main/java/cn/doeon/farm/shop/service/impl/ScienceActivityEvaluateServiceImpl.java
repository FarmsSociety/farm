package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ActivityEvaluateDto;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.dao.ScienceActivityEvaluateMapper;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceActivityEvaluateServiceImpl extends ServiceImpl<ScienceActivityEvaluateMapper, ActivityEvaluate> implements ScienceActivityEvaluateService {
    @Autowired
    private ScienceActivityEvaluateMapper scienceActivityEvaluateMapper;

    @Override
    public IPage<ActivityEvaluate> getActivityEvaluateList(Page page, String activityId) {
        return scienceActivityEvaluateMapper.getActivityEvaluateList(page, activityId);
    }

    @Override
    public IPage<ActivityEvaluateDto> listByUserId(Page<ActivityInfo> page, String userId) {
        return scienceActivityEvaluateMapper.listByUserId(page, userId);
    }
}
