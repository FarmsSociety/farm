package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.dao.ScienceExpertMapper;
import cn.doeon.farm.shop.service.ScienceExpertService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScienceExpertServiceImpl extends ServiceImpl<ScienceExpertMapper, Expert> implements ScienceExpertService {
    @Autowired
    private ScienceExpertMapper scienceExpertMapper;

    @Override
    public IPage<Expert> getExpertList(Page page, ExpertDto expertDto) {
        return scienceExpertMapper.getExpertList(page,expertDto);
    }

    @Override
    public Expert getExpertInfoByName(String name) {
        return scienceExpertMapper.getExpertInfoByName(name);
    }
}
