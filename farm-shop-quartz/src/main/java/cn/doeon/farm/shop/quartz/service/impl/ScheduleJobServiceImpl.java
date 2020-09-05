/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.quartz.service.impl;

import cn.doeon.farm.shop.quartz.config.ScheduleManager;
import cn.doeon.farm.shop.quartz.dao.ScheduleJobMapper;
import cn.doeon.farm.shop.quartz.model.ScheduleJob;
import cn.doeon.farm.shop.quartz.service.ScheduleJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.doeon.farm.shop.quartz.enums.ScheduleStatus;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author lgh
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {
	
	@Autowired
	private ScheduleJobMapper scheduleJobMapper;
	@Autowired
	private ScheduleManager scheduleManager;
	/**
	 * 项目启动时，初始化定时器
	 */
	@PostConstruct
	public void init(){
		list().forEach(scheduleJob -> {
			CronTrigger trigger = scheduleManager.getCronTrigger(scheduleJob);
			// 如果定时任务不存在，则创建定时任务
			if (trigger == null) {
				scheduleManager.createScheduleJob(scheduleJob);
			} else if (ScheduleStatus.NORMAL.getType().equals(scheduleJob.getStatus())) {
				scheduleManager.resumeJob(scheduleJob);
			} else if (ScheduleStatus.PAUSE.getType().equals(scheduleJob.getStatus())) {
				scheduleManager.pauseJob(scheduleJob);
			}
		});
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveAndStart(ScheduleJob scheduleJob) {
		scheduleJob.setCreateTime(new Date());
		scheduleJob.setStatus(ScheduleStatus.NORMAL.getType());
		scheduleJobMapper.insert(scheduleJob);
        
        scheduleManager.createScheduleJob(scheduleJob);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateScheduleJob(ScheduleJob scheduleJob) {
		scheduleManager.updateScheduleJob(scheduleJob);
		scheduleJobMapper.updateById(scheduleJob);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] jobIds) {

		List<Long> ids = Arrays.asList(jobIds);
		this.listByIds(ids).forEach(scheduleJob -> {
			scheduleManager.deleteScheduleJob(scheduleJob);
		});
		scheduleJobMapper.deleteBatchIds(ids);
	}

	@Override
	public int updateBatch(Long[] jobIds, int status) {
		return scheduleJobMapper.updateBatch(jobIds,status);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
    public void run(Long[] jobIds) {
    	for(Long jobId : jobIds){
    		scheduleManager.run(scheduleJobMapper.selectById(jobId));
    	}
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void pause(Long[] jobIds) {
		this.listByIds(Arrays.asList(jobIds)).forEach(scheduleJob -> {
			scheduleManager.pauseJob(scheduleJob);
		});
        
    	updateBatch(jobIds, ScheduleStatus.PAUSE.getType());
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
    public void resume(Long[] jobIds) {
		this.listByIds(Arrays.asList(jobIds)).forEach(scheduleJob -> {
			scheduleManager.resumeJob(scheduleJob);
		});

    	updateBatch(jobIds, ScheduleStatus.NORMAL.getType());
    }
}