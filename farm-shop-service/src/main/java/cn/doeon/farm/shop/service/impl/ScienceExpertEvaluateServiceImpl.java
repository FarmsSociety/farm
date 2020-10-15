package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.EvaluateDto;
import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.bean.model.science.ExpertEvaluate;
import cn.doeon.farm.shop.dao.ScienceExpertEvaluateMapper;
import cn.doeon.farm.shop.dao.ScienceExpertMapper;
import cn.doeon.farm.shop.service.ScienceExpertEvaluateService;
import cn.doeon.farm.shop.service.ScienceExpertService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceExpertEvaluateServiceImpl extends ServiceImpl<ScienceExpertEvaluateMapper, ExpertEvaluate> implements ScienceExpertEvaluateService {
    @Autowired
    private ScienceExpertEvaluateMapper scienceExpertEvaluateMapper;


    @Override
    public boolean updateExpertEvaluateStatus(String id, Integer verifyStatu) {
        return scienceExpertEvaluateMapper.updateExpertEvaluateStatus(id,verifyStatu);
    }

    @Override
    public IPage<ExpertEvaluate> getexpertEvaluatelist(Page<ExpertEvaluate> page, EvaluateDto expert) {
        return scienceExpertEvaluateMapper.getexpertEvaluatelist(page,expert);
    }
}
