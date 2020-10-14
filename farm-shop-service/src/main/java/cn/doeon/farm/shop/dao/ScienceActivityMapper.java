package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.ActivityInfoDto;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceActivityMapper extends BaseMapper<ActivityInfo> {

    IPage<ActivityInfo> getActivityList(Page page,@Param("activityInfo") ActivityInfoDto activityInfo);

    int deleteActivityById(@Param("id")String id);

    ActivityInfo getActivityInfoById(@Param("id")String id);

    int updateActivityStatus(@Param("id")String id, @Param("activityStatus") Integer activityStatus);
}
