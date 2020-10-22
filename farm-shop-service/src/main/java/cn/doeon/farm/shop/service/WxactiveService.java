/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.service;


import cn.doeon.farm.shop.bean.app.dto.WxactiveDto;
import cn.doeon.farm.shop.bean.model.Wxactive;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.doeon.farm.shop.bean.app.dto.NoticeDto;
import cn.doeon.farm.shop.bean.model.Notice;

import java.util.List;

/**
 * 公告管理
 *
 * @author hzm
 * @date 2019-04-18 21:21:40
 */
public interface WxactiveService extends IService<Wxactive> {

    List<Wxactive> listWxactive();

    void removeWxactiveList();

    Page<WxactiveDto> pageNotice(Page<WxactiveDto> page);

    Wxactive getNoticeById(Long wxactiveId);

    void removeNoticeById(Long wxactiveId);
}
