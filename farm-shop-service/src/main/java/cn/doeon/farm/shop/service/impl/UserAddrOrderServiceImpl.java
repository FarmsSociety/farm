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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.doeon.farm.shop.dao.UserAddrOrderMapper;
import org.springframework.stereotype.Service;

import cn.doeon.farm.shop.bean.model.UserAddrOrder;
import cn.doeon.farm.shop.service.UserAddrOrderService;

@Service
public class UserAddrOrderServiceImpl extends ServiceImpl<UserAddrOrderMapper, UserAddrOrder> implements UserAddrOrderService{

}
