/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.security.service;

import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @author
 * @tate 2019/03/30
 * 获取客户端
 */
public class YamiClientDetailsService extends JdbcClientDetailsService {

	public YamiClientDetailsService(DataSource dataSource) {
		super(dataSource);
	}
}