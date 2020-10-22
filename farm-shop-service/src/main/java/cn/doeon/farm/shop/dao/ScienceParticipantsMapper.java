package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.ScienceParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import cn.doeon.farm.shop.bean.model.science.ScienceParticipants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceParticipantsMapper extends BaseMapper<ScienceParticipants> {

    int updatePersonScienceStatus(@Param("id")String id, @Param("signStatus") Integer signStatus);

    IPage<ScienceParticipants> getSignUpScienceList(Page<ScienceParticipants> page, @Param("scienceParticipantsDto") ScienceParticipantsDto scienceParticipantsDto);
}
