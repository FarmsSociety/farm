package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.dto.ScienceParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import cn.doeon.farm.shop.bean.model.science.ScienceParticipants;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceParticipantsService extends IService<ScienceParticipants> {

    boolean updatePersonScienceStatus(String id, Integer signStatus);

    IPage<ScienceParticipants> getSignUpScienceList(Page<ScienceParticipants> page, ScienceParticipantsDto scienceParticipantsDto);
}
