package cn.doeon.farm.shop.service.impl;

import cn.doeon.farm.shop.bean.dto.ActivityEvaluateDto;
import cn.doeon.farm.shop.bean.dto.MemberDto;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.Member;
import cn.doeon.farm.shop.dao.ScienceActivityEvaluateMapper;
import cn.doeon.farm.shop.dao.ScienceMemberMapper;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import cn.doeon.farm.shop.service.ScienceMemberService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScienceMemberServiceImpl extends ServiceImpl<ScienceMemberMapper, Member> implements ScienceMemberService {
    @Autowired
    private ScienceMemberMapper scienceMemberMapper;


    @Override
    public IPage<Member> getMemberList(Page<Member> page, MemberDto memberDto) {
        return scienceMemberMapper.getMemberList(page,memberDto);
    }

    @Override
    public Member getMemberInfoByName(String name) {
        return scienceMemberMapper.getMemberInfoByName(name);
    }
}
