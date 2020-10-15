package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ActivityEvaluateDto;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceActivityEvaluateService extends IService<ActivityEvaluate> {

    IPage<ActivityEvaluate> getActivityEvaluateList(Page page, String activityId);

    IPage<ActivityEvaluateDto> listByUserId(Page<ActivityInfo> page, String userId);
}
