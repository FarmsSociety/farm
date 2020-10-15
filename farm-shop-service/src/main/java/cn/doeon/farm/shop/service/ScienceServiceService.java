package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ScienceServiceDto;
import cn.doeon.farm.shop.bean.model.science.Member;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceServiceService extends IService<ScienceService> {

    IPage<ScienceService> getScienceServiceList(Page<ScienceService> page, ScienceServiceDto scienceServiceDto);
}
