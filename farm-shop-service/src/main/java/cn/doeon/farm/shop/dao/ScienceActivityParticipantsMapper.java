package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceActivityParticipantsMapper extends BaseMapper<ActivityParticipants> {


    int updatePersonActivityStatus(@Param("id")String id, @Param("signStatus") Integer signStatus);

    IPage<ActivityParticipants> getSignUpActivityList(Page<ActivityParticipants> page,@Param("activityParticipantsDto") ActivityParticipantsDto activityParticipantsDto);
}
