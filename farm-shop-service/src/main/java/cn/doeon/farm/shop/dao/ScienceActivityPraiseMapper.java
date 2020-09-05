package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ScienceActivityPraiseMapper extends BaseMapper<ActivityPraise> {

    String getActivityPraiseInfo(@Param("activityId")String activityId, @Param("userId") String userId);
}
