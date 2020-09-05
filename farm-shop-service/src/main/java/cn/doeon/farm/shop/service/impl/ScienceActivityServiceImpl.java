package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.dao.ScienceActivityMapper;
import cn.doeon.farm.shop.service.ScienceActivityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceActivityServiceImpl extends ServiceImpl<ScienceActivityMapper, ActivityInfo> implements ScienceActivityService {
    @Autowired
    private ScienceActivityMapper scienceActivityMapper;

    @Override
    public IPage<ActivityInfo> getActivityList(Page page) {
        return scienceActivityMapper.getActivityList(page);
    }

    @Override
    public boolean deleteActivityById(String id) {
        return scienceActivityMapper.deleteActivityById(id) > 0;
    }

    @Override
    public ActivityInfo getActivityInfoById(String id) {
        return scienceActivityMapper.getActivityInfoById(id);
    }

    @Override
    public boolean updateActivityStatus(String id, Integer activityStatus) {
        return scienceActivityMapper.updateActivityStatus(id, activityStatus) > 0;
    }
}
