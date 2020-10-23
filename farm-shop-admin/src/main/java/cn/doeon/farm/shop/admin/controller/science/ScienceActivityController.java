/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.admin.controller.science;

import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.dto.ActivityInfoDto;
import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.ActivityParticipants;
import cn.doeon.farm.shop.bean.model.science.ActivityPraise;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import cn.doeon.farm.shop.service.ScienceActivityParticipantsService;
import cn.doeon.farm.shop.service.ScienceActivityPraiseService;
import cn.doeon.farm.shop.service.ScienceActivityService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author hexiangyi on 2018/10/26.
 */
@RestController
@RequestMapping("/science/activity")
@Api(tags = "活动招募模块")
public class ScienceActivityController {

    @Autowired
    private ScienceActivityService scienceActivityService;
    @Autowired
    private ScienceActivityParticipantsService scienceActivityParticipantsService;
    @Autowired
    private ScienceActivityEvaluateService scienceActivityEvaluateService;
    @Autowired
    private ScienceActivityPraiseService scienceActivityPraiseService;

    /**
     * 获取活动列表接口
     *
     * @return
     */
    @ApiOperation(value = "获取活动招募列表", notes = "获取活动招募列表")
    @GetMapping("/list")
    public ResponseResult<IPage<ActivityInfo>> getActivityList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               ActivityInfoDto activityInfo) {
        ResponseResult<IPage<ActivityInfo>> result = new ResponseResult<>();
        Page<ActivityInfo> page = new Page<>(pageNo, pageSize);
        IPage<ActivityInfo> activityList = scienceActivityService.getActivityList(page,activityInfo);
        result.setData(activityList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    /**
     * 发布活动接口
     *
     * @return
     */
    @ApiOperation(value = "活动信息添加", notes = "活动信息添加")
    @PostMapping("/publish")
    public ResponseResult publishActivity(@RequestBody ActivityInfo activityInfo) {
        scienceActivityService.saveOrUpdate(activityInfo);
        ResponseResult result = new ResponseResult();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;

    }

    /**
     * 删除活动接口
     *
     * @return
     */
    @ApiOperation(value = "活动信息删除", notes = "活动信息删除")
    @DeleteMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult deleteActivityById(@RequestParam(name = "id") String id) {
        boolean isSuccess = scienceActivityService.deleteActivityById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 通过活动ID，查询活动信息
     *
     * @return
     */
    @ApiOperation(value = "活动信息详情", notes = "活动信息详情")
    @GetMapping("/info")
    public ResponseResult<ActivityInfo> getActivityInfoById(@RequestParam(name = "id") String id) {
        ActivityInfo activityInfo = scienceActivityService.getActivityInfoById(id);
        ResponseResult<ActivityInfo> result = new ResponseResult<>();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        result.setData(activityInfo);
        return result;
    }

    /**
     * 通过活动ID，更新活动状态信息
     *
     * @return
     */
    @ApiOperation(value = "活动信息更新", notes = "活动信息更新接口")
    @PutMapping("/status")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult updateActivityStatus(@RequestParam(name = "id") String id,
                                                        @RequestParam(name = "activityStatus") Integer activityStatus) {
        boolean isSuccess = scienceActivityService.updateActivityStatus(id, activityStatus);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    @ApiOperation(value = "活动点赞", notes = "活动点赞接口")
    @PostMapping("/praise")
    public ResponseResult activityPraiseConfirm(@RequestBody ActivityPraise activityPraise){
        String praiseId = scienceActivityPraiseService.getActivityPraiseInfo(activityPraise.getActivityId(), activityPraise.getUserId());
        if(null != praiseId){
            activityPraise.setId(praiseId);
        }
        boolean isSuccess = scienceActivityPraiseService.saveOrUpdate(activityPraise);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
     /**
      * @Author hexy
      * @Description  活动报名
      * @Date 10:51 2020/10/15
      * @Param 
      * @return 
     */
     @ApiOperation(value = "活动参与报名", notes = "活动参与报名")
     @PostMapping("/participateActivity")
     public ResponseResult participateActivity(@RequestBody ActivityParticipants activityParticipants) {
         scienceActivityParticipantsService.saveOrUpdate(activityParticipants);
         ResponseResult result = new ResponseResult();
         result.setStatus(ResultStatus.SUCCESS.value());
         result.setMsg(ResultMsg.MSG_SUCCESS);
         return result;
     }
      /**
       * @Author hexy
       * @Description 活动参与报名状态审核
       * @Date 11:38 2020/10/15
       * @Param 
       * @return 
      */   
    @ApiOperation(value = "活动参与报名状态审核", notes = "活动参与报名状态审核")
    @PutMapping("/updatePersonActivityStatus")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult updatePersonActivityStatus(@RequestParam(name = "id") String id,
                                               @RequestParam(name = "signStatus") Integer signStatus) {
        boolean isSuccess = scienceActivityParticipantsService.updatePersonActivityStatus(id, signStatus);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
     /**
      * @Author hexy
      * @Description  活动参与报名列表
      * @Date 11:57 2020/10/15
      * @Param 
      * @return 
     */
    @ApiOperation(value = "活动参与报名列表", notes = "活动参与报名列表")
    @GetMapping("/getSignUpActivityList")
    public ResponseResult<IPage<ActivityParticipants>> getSignUpActivityList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               ActivityParticipantsDto activityParticipantsDto) {
        ResponseResult<IPage<ActivityParticipants>> result = new ResponseResult<>();
        Page<ActivityParticipants> page = new Page<>(pageNo, pageSize);
        IPage<ActivityParticipants> activityList = scienceActivityParticipantsService.getSignUpActivityList(page,activityParticipantsDto);
        result.setData(activityList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }



}
