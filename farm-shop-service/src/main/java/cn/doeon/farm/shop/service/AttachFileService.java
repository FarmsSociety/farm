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

import java.io.IOException;

import cn.doeon.farm.shop.bean.vo.FileVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.doeon.farm.shop.bean.model.AttachFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * Created by lgh on 2018/07/27.
 */
public interface AttachFileService extends IService<AttachFile> {

	String uploadFile(MultipartFile file) throws IOException;
	void deleteFile(String fileName);
}
