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

import java.util.List;

import cn.doeon.farm.shop.dao.OrderItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.doeon.farm.shop.bean.model.OrderItem;
import cn.doeon.farm.shop.service.OrderItemService;

/**
 *
 * @author lgh on 2018/09/15.
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

	@Override
	@Cacheable(cacheNames = "OrderItems", key = "#orderNumber")
	public List<OrderItem> getOrderItemsByOrderNumber(String orderNumber) {
		return orderItemMapper.listByOrderNumber(orderNumber);
	}


}