package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ScienceExpertService extends IService<Expert> {

    IPage<Expert> getExpertList(Page page, ExpertDto expertDto);

    Expert getExpertInfoByName(String name);
}
