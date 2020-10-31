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

    @Autowired
    private Auth auth;
	// 文件的真实路径
//	@Value("${file.uploadPath}")
//	private String realBasePath;
//	@Value("${file.uploadPath}")
//	private String UPLOAD_FOLDER;
//
//	@Value("${server.port}")
//	private int port;

    public final static String NORM_MONTH_PATTERN = "yyyy/MM/";

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String uploadFile(MultipartFile mfile) throws IOException {
		byte[] bytes = mfile.getBytes();
		String originalName = mfile.getOriginalFilename();
		String extName = FileUtil.extName(originalName);
		String format = DateUtil.format(new Date(), NORM_MONTH_PATTERN);
		// 真实路径，实际储存的路径
		String path = "/root/tmp/";
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



	@Override
	public FileVo uploadImg(MultipartFile file) {
		//			// 判断是否为空
//			if (Objects.isNull(file)) {
//				log.error("上传图片异常：{}", Message.UPLOAD_NUll_ERROR.getMsg());
//				throw new BusinessException(Message.UPLOAD_NUll_ERROR.getMsg());
//			}
//			// 不能大于10M
//			if (file.getSize() > 1024 * 1024 * 10) {
//				log.error("上传图片异常：{}", Message.UPLOAD_SIZE_ERROR.getMsg());
//				throw new BusinessException(Message.UPLOAD_SIZE_ERROR.getMsg());
//			}
//
//			// 获取图片原名称
//			String imgName = file.getOriginalFilename();
//			// 图片重命名
//			String filename = UUIDUtil.getUUID(10) + imgName.substring(imgName.lastIndexOf("."));
//
//			File savePathFile = new File(UPLOAD_FOLDER);
//			if (!savePathFile.exists()) {
//				//若不存在该目录，则创建目录
//				savePathFile.mkdirs();
//			}
//
//			//将文件保存指定目录
//			File newFile = new File(savePathFile.getAbsolutePath() + File.separator + filename);
//			file.transferTo(newFile);
//			// 返回信息
//			String imgUrl = Constants.HTTP + InetAddress.getLocalHost().getHostAddress() + ":" + port + Constants.CONTEXT_PATH + Constants.UPLOAD + filename;
//
//			return FileVo.builder().filename(filename).imgUrl(imgUrl).build();
		return new FileVo();
	}
}
