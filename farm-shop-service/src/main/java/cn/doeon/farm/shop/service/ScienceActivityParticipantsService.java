package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ActivityInfoDto;
import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceActivityParticipantsService extends IService<ActivityParticipants> {


    boolean updatePersonActivityStatus(String id, Integer signStatus);

    IPage<ActivityParticipants> getSignUpActivityList(Page<ActivityParticipants> page, ActivityParticipantsDto activityParticipantsDto);
}
