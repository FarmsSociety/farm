package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceActivityService extends IService<ActivityInfo> {

    IPage<ActivityInfo> getActivityList(Page page);

    boolean deleteActivityById(String id);

    ActivityInfo getActivityInfoById(String id);

    boolean updateActivityStatus(String id, Integer activityStatus);
}
