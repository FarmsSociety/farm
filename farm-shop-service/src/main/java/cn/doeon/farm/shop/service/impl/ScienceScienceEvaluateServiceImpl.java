package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ScienceEvaluate;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import cn.doeon.farm.shop.dao.ScienceScienceEvaluateServiceMapper;
import cn.doeon.farm.shop.service.ScienceScienceEvaluateService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceScienceEvaluateServiceImpl extends ServiceImpl<ScienceScienceEvaluateServiceMapper, ScienceEvaluate> implements ScienceScienceEvaluateService {
    @Autowired
    private ScienceScienceEvaluateServiceMapper scienceScienceEvaluateMapper;

    @Override
    public IPage<ScienceEvaluate> getScienceEvaluateList(Page<ScienceService> page, String scienceId) {
        return scienceScienceEvaluateMapper.getScienceEvaluateList(page, scienceId);
    }
}
