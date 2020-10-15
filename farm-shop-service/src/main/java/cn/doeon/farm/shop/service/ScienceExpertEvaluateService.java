package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.EvaluateDto;
import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.bean.model.science.ExpertEvaluate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceExpertEvaluateService extends IService<ExpertEvaluate> {


    boolean updateExpertEvaluateStatus(String id, Integer verifyStatu);

    IPage<ExpertEvaluate> getexpertEvaluatelist(Page<ExpertEvaluate> page, EvaluateDto expert);
}
