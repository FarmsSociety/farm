package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ScienceEvaluate;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceScienceEvaluateService extends IService<ScienceEvaluate> {

    IPage<ScienceEvaluate> getScienceEvaluateList(Page<ScienceService> page, String scienceId);
}
