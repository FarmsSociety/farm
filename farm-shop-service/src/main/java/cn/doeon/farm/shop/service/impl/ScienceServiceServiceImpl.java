package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ScienceServiceDto;
import cn.doeon.farm.shop.bean.model.science.Member;
import cn.doeon.farm.shop.bean.model.science.ScienceService;
import cn.doeon.farm.shop.dao.ScienceMemberMapper;
import cn.doeon.farm.shop.dao.ScienceServiceMapper;
import cn.doeon.farm.shop.service.ScienceMemberService;
import cn.doeon.farm.shop.service.ScienceServiceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceServiceServiceImpl extends ServiceImpl<ScienceServiceMapper, ScienceService> implements ScienceServiceService {
    @Autowired
    private ScienceServiceMapper scienceServiceMapper;

    @Override
    public IPage<ScienceService> getScienceServiceList(Page<ScienceService> page, ScienceServiceDto scienceServiceDto) {
        return scienceServiceMapper.getScienceServiceList(page,scienceServiceDto);
    }
}
