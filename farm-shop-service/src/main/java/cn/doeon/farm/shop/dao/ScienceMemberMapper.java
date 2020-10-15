package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.ActivityEvaluateDto;
import cn.doeon.farm.shop.bean.dto.MemberDto;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface ScienceMemberMapper extends BaseMapper<Member> {


    IPage<Member> getMemberList(Page<Member> page, @Param("memberDto") MemberDto memberDto);

    Member getMemberInfoByName(@Param("name")String name);
}
