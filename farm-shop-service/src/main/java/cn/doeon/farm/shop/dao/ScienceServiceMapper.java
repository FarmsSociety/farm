package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.ScienceServiceDto;
import cn.doeon.farm.shop.bean.model.science.Member;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceServiceMapper extends BaseMapper<ScienceService> {

    IPage<ScienceService> getScienceServiceList(Page<ScienceService> page, @Param("scienceServiceDto") ScienceServiceDto scienceServiceDto);
}
