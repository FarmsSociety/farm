package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.model.science.ScienceEvaluate;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceScienceEvaluateServiceMapper extends BaseMapper<ScienceEvaluate> {
    IPage<ScienceEvaluate> getScienceEvaluateList(Page<ScienceService> page, @Param("scienceId") String scienceId);
}
