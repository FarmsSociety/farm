package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import cn.doeon.farm.shop.dao.ScienceActivityEvaluateMapper;
import cn.doeon.farm.shop.dao.ScienceActivityParticipantsMapper;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import cn.doeon.farm.shop.service.ScienceActivityParticipantsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceActivityParticipantsServiceImpl extends ServiceImpl<ScienceActivityParticipantsMapper, ActivityParticipants> implements ScienceActivityParticipantsService {
    @Autowired
    private ScienceActivityParticipantsMapper scienceActivityParticipantsMapper;

    @Override
    public boolean updatePersonActivityStatus(String id, Integer signStatus) {
        return scienceActivityParticipantsMapper.updatePersonActivityStatus(id, signStatus) > 0;
    }

    @Override
    public IPage<ActivityParticipants> getSignUpActivityList(Page<ActivityParticipants> page, ActivityParticipantsDto activityParticipantsDto) {
        return scienceActivityParticipantsMapper.getSignUpActivityList(page,activityParticipantsDto);
    }
}
