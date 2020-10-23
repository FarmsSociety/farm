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


import cn.doeon.farm.shop.bean.app.dto.WxactiveDto;
import cn.doeon.farm.shop.bean.model.Wxactive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 公告管理
 *
 * @author hzm
 * @date 2019-04-18 21:21:40
 */
public interface WxactiveMapper extends BaseMapper<Wxactive> {

    Page<WxactiveDto> pageWxactive(Page<WxactiveDto> page);
}
