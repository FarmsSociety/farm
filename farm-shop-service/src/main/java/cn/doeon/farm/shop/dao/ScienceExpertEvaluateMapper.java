package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.EvaluateDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.bean.model.science.ExpertEvaluate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceExpertEvaluateMapper extends BaseMapper<ExpertEvaluate> {

    boolean updateExpertEvaluateStatus(@Param("id")String id, @Param("verifyStatu") Integer verifyStatu);

    IPage<ExpertEvaluate> getexpertEvaluatelist(Page<ExpertEvaluate> page, @Param("expertEvaluate") EvaluateDto expertEvaluate);
}
