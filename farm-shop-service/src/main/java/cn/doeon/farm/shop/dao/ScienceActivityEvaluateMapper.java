package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.Expert;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceActivityEvaluateMapper extends BaseMapper<ActivityEvaluate> {

    IPage<ActivityEvaluate> getActivityEvaluateList(Page page, @Param("activityId")String activityId);
}
