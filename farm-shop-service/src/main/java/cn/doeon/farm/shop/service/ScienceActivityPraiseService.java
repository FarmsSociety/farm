package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceActivityPraiseService extends IService<ActivityPraise> {
    String getActivityPraiseInfo(String activityId, String userId);
}
