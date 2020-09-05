package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.model.science.Expert;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScienceExpertMapper extends BaseMapper<Expert> {

    IPage<Expert> getExpertList(Page page);

    Expert getExpertInfoByName(@Param("name")String name);
}
