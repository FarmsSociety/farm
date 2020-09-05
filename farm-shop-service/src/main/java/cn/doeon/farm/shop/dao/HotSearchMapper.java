/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.dao;

import cn.doeon.farm.shop.bean.dto.HotSearchDto;
import cn.doeon.farm.shop.bean.model.HotSearch;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface HotSearchMapper extends BaseMapper<HotSearch> {
    List<HotSearchDto> getHotSearchDtoByShopId(Long shopId);
}