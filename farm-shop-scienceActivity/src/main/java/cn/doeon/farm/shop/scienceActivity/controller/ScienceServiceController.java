/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.scienceActivity.controller;

import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.dto.ActivityInfoDto;
import cn.doeon.farm.shop.bean.dto.ActivityParticipantsDto;
import cn.doeon.farm.shop.bean.dto.ScienceParticipantsDto;
import cn.doeon.farm.shop.bean.dto.ScienceServiceDto;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.*;
import cn.doeon.farm.shop.service.*;
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
@RequestMapping("/science/service")
@Api(tags = "科技服务模块")
public class ScienceServiceController {

    @Autowired
    private ScienceServiceService scienceServiceService;
    @Autowired
    private ScienceParticipantsService scienceParticipantsService;
    @Autowired
    private ScienceScienceEvaluateService scienceScienceEvaluateService;
    @Autowired
    private ScienceActivityPraiseService scienceActivityPraiseService;

    /**
     * 获取科技服务列表
     *
     * @return
     */
    @ApiOperation(value = "获取科技服务列表", notes = "获取科技服务列表")
    @GetMapping("/list")
    public ResponseResult<IPage<ScienceService>> getScienceServiceList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               ScienceServiceDto scienceServiceDto) {
        ResponseResult<IPage<ScienceService>> result = new ResponseResult<>();
        Page<ScienceService> page = new Page<>(pageNo, pageSize);
        IPage<ScienceService> activityList = scienceServiceService.getScienceServiceList(page,scienceServiceDto);
        result.setData(activityList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    /**
     * 科技服务删除
     *
     * @return
     */
    @ApiOperation(value = "科技服务删除", notes = "科技服务删除")
    @DeleteMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult deleteServiceServiceById(@RequestParam(name = "id") String id) {
        boolean isSuccess = scienceServiceService.removeById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 通过活动ID，科技服务详情
     *
     * @return
     */
    @ApiOperation(value = "科技服务详情-活动ID", notes = "科技服务详情-活动ID")
    @GetMapping("/info")
    public ResponseResult<ScienceService> getServiceServiceById(@RequestParam(name = "id") String id) {
        ScienceService activityInfo = scienceServiceService.getById(id);
        ResponseResult<ScienceService> result = new ResponseResult<>();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        result.setData(activityInfo);
        return result;
    }

    /**
     * 科技服务修改
     * @return
     */
    @ApiOperation(value = "科技服务修改", notes = "科技服务修改")
    @PutMapping("/update")
    public ResponseResult updateExpert(@RequestBody ScienceService scienceService) {
        boolean isSuccess = scienceServiceService.updateById(scienceService);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
    /**
     * 科技服务添加
     * @return
     */
    @ApiOperation(value = "科技服务添加", notes = "科技服务添加")
    @PostMapping("/add")
    public ResponseResult addScienceService(@RequestBody ScienceService scienceService) {
        boolean isSuccess = scienceServiceService.save(scienceService);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * @Author hexy
     * @Description  科技服务报名
     * @Date 10:51 2020/10/15
     * @Param
     * @return
     */
    @ApiOperation(value = "科技服务报名", notes = "科技服务报名")
    @PostMapping("/scienceSignUp")
    public ResponseResult scienceSignUp(@RequestBody ScienceParticipants scienceParticipants) {
        scienceParticipantsService.saveOrUpdate(scienceParticipants);
        ResponseResult result = new ResponseResult();
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }
    /**
     * @Author hexy
     * @Description 科技服务报名审核
     * @Date 11:38 2020/10/15
     * @Param
     * @return
     */
    @ApiOperation(value = "科技服务报名审核", notes = "科技服务报名审核")
    @PutMapping("/updatePersonScienceStatus")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult updatePersonScienceStatus(@RequestParam(name = "id") String id,
                                                     @RequestParam(name = "signStatus") Integer signStatus) {
        boolean isSuccess = scienceParticipantsService.updatePersonScienceStatus(id, signStatus);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * @Author hexy
     * @Description  科技服务报名列表
     * @Date 11:57 2020/10/15
     * @Param
     * @return
     */
    @ApiOperation(value = "科技服务报名列表", notes = "科技服务报名列表")
    @GetMapping("/getSignUpScienceList")
    public ResponseResult<IPage<ScienceParticipants>> getSignUpScienceList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             ScienceParticipantsDto scienceParticipantsDto) {
        ResponseResult<IPage<ScienceParticipants>> result = new ResponseResult<>();
        Page<ScienceParticipants> page = new Page<>(pageNo, pageSize);
        IPage<ScienceParticipants> scienceList = scienceParticipantsService.getSignUpScienceList(page,scienceParticipantsDto);
        result.setData(scienceList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    /**
     * 通过ID科技服务报名详情
     * @return
     */
    @ApiOperation(value = "通过ID获取科技服务报名人详情", notes = "通过ID获取科技服务报名人详情")
    @GetMapping("/infoById")
    public ResponseResult<ScienceParticipants> getScienceInfoById(@RequestParam (name = "id") String id) {
        ResponseResult<ScienceParticipants> result = new ResponseResult<>();
        ScienceParticipants expert = scienceParticipantsService.getById(id);
        result.setData(expert);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    @ApiOperation(value = "获取某个科技服务评论列表-根据科技服务id获取", notes = "获取某个科技服务评论列表-根据科技服务id获取")
    @GetMapping("/listByScienceId")
    public ResponseResult<IPage<ScienceEvaluate>> getScienceEvaluateList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @RequestParam(name = "scienceId")String ScienceId) {
        ResponseResult<IPage<ScienceEvaluate>> result = new ResponseResult<>();
        Page<ScienceService> page = new Page<>(pageNo, pageSize);
        IPage<ScienceEvaluate> evaluateList = scienceScienceEvaluateService.getScienceEvaluateList(page, ScienceId);
        result.setData(evaluateList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }
    /**
     * 删除科技服务接口
     * @return
     */
    @ApiOperation(value = "删除科技服务接口", notes = "删除科技服务接口")
    @DeleteMapping("/deleteService")
    public ResponseResult deleteService(@RequestParam (name = "id") String id) {
        boolean isSuccess = scienceScienceEvaluateService.removeById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
    /**
     * 科技服务评价修改接口
     * @return
     */
    @ApiOperation(value = "科技服务评价修改接口", notes = "科技服务评价修改接口")
    @PutMapping("/updateEvaluateById")
    public ResponseResult updateEvaluateById(@RequestBody ScienceEvaluate expert) {
        boolean isSuccess = scienceScienceEvaluateService.updateById(expert);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }
    /**
     * 科技服务添加添加
     * @return
     */
    @ApiOperation(value = "科技服务添加", notes = "科技服务添加")
    @PostMapping("/addScienceEvaluation")
    public ResponseResult addScienceEvaluation(@RequestBody ScienceEvaluate expertEvaluate) {
        boolean isSuccess = scienceScienceEvaluateService.save(expertEvaluate);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }


}
