/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.service.impl;


import cn.doeon.farm.shop.bean.app.dto.WxactiveDto;
import cn.doeon.farm.shop.bean.model.Wxactive;
import cn.doeon.farm.shop.dao.WxactiveMapper;
import cn.doeon.farm.shop.service.WxactiveService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告管理
 *
 * @author hzm
 * @date 2019-04-18 21:21:40
 */
@Service
@AllArgsConstructor
public class WxactiveServiceImpl extends ServiceImpl<WxactiveMapper, Wxactive> implements WxactiveService {

    private WxactiveMapper wxactiveMapper;

    @Override
    @Cacheable(cacheNames = "notices", key = "'notices'")
    public List<Wxactive> listWxactive() {
        return wxactiveMapper.selectList(new LambdaQueryWrapper<Wxactive>()
                .eq(Wxactive::getStatus, 1)
                .orderByDesc(Wxactive::getCreateTime));
    }

    @Override
    @CacheEvict(cacheNames = "notices", key = "'wxactiveId'")
    public void removeWxactiveList() {
    }

    @Override
    public Page<WxactiveDto> pageWxactive(Page<WxactiveDto> page) {
        return wxactiveMapper.pageWxactive(page);
    }

    @Override
    @Cacheable(cacheNames = "notice", key = "#wxactiveId")
    public Wxactive getWxactiveById(Long wxactiveId) {
        return wxactiveMapper.selectById(wxactiveId);
    }

    @Override
    @CacheEvict(cacheNames = "notice", key = "#wxactiveId")
    public void removeWxactiveById(Long wxactiveId) {
    }


}
