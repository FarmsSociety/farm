package cn.doeon.farm.shop.service;

import cn.doeon.farm.shop.bean.dto.ExpertDto;
import cn.doeon.farm.shop.bean.dto.MemberDto;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.bean.model.science.Member;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ScienceMemberService extends IService<Member> {


    IPage<Member> getMemberList(Page<Member> page, MemberDto memberDto);


    Member getMemberInfoByName(String name);
}
