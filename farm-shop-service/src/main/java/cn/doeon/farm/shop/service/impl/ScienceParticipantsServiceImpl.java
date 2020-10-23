package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.dto.ScienceParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import cn.doeon.farm.shop.bean.model.science.ScienceParticipants;
import cn.doeon.farm.shop.dao.ScienceActivityParticipantsMapper;
import cn.doeon.farm.shop.dao.ScienceParticipantsMapper;
import cn.doeon.farm.shop.service.ScienceActivityParticipantsService;
import cn.doeon.farm.shop.service.ScienceParticipantsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceParticipantsServiceImpl  extends ServiceImpl<ScienceParticipantsMapper, ScienceParticipants> implements ScienceParticipantsService {
    @Autowired
    private ScienceParticipantsMapper scienceParticipantsMapper;

    @Override
    public boolean updatePersonScienceStatus(String id, Integer signStatus) {
        return scienceParticipantsMapper.updatePersonScienceStatus(id, signStatus) > 0;
    }

    @Override
    public IPage<ScienceParticipants> getSignUpScienceList(Page<ScienceParticipants> page, ScienceParticipantsDto scienceParticipantsDto) {
        return scienceParticipantsMapper.getSignUpScienceList(page,scienceParticipantsDto);
    }
}