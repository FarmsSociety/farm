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

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.Objects;

import cn.doeon.farm.shop.bean.enums.Message;
import cn.doeon.farm.shop.bean.exception.BusinessException;
import cn.doeon.farm.shop.bean.exception.Constants;
import cn.doeon.farm.shop.bean.vo.FileVo;
import cn.doeon.farm.shop.common.util.FileUploadUtil;
import cn.doeon.farm.shop.common.util.UUIDUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import cn.doeon.farm.shop.bean.model.AttachFile;
import cn.doeon.farm.shop.common.bean.Qiniu;
import cn.doeon.farm.shop.dao.AttachFileMapper;
import cn.doeon.farm.shop.service.AttachFileService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * Created by lgh on 2018/07/27.
 */
@Slf4j
@Service
public class AttachFileServiceImpl extends ServiceImpl<AttachFileMapper, AttachFile> implements AttachFileService {

    @Autowired
    private AttachFileMapper attachFileMapper;

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;


	@Value("${file.uploadPath}")
	private String UPLOAD_FOLDER;

    public final static String NORM_MONTH_PATTERN = "yyyy/MM/";

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String uploadFile(MultipartFile mfile) throws IOException {
		byte[] bytes = mfile.getBytes();
		String originalName = mfile.getOriginalFilename();
		String extName = FileUtil.extName(originalName);
		String path = UPLOAD_FOLDER+DateUtil.format(new Date(), NORM_MONTH_PATTERN);
		String picName = IdUtil.simpleUUID() + "." + extName;
		String fileName = path+ picName;
		AttachFile attachFile = new AttachFile();
		attachFile.setFilePath(fileName);
		attachFile.setFileSize(bytes.length);
		attachFile.setFileType(extName);
		attachFile.setUploadTime(new Date());
		attachFileMapper.insert(attachFile);

		FileUploadUtil.approvalFile(mfile,path,picName);
		return fileName;
	}

	@Override
	public void deleteFile(String fileName){
		attachFileMapper.delete(new LambdaQueryWrapper<AttachFile>().eq(AttachFile::getFilePath,fileName));
		try {
			new File(fileName).delete();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
