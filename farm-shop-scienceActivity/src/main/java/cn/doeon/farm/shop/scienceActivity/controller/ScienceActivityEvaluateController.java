package cn.doeon.farm.shop.scienceActivity.controller;


import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.ActivityEvaluate;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.service.ScienceActivityEvaluateService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/science/evaluate")
@Api(tags = "活动评论点赞模块接口")
public class ScienceActivityEvaluateController {

    @Autowired
    private ScienceActivityEvaluateService scienceActivityEvaluateService;

    @ApiOperation(value = "获取某个活动评论列表", notes = "获取某个活动评论列表")
    @GetMapping("/listByActivityId")
    public ResponseResult<IPage<ActivityEvaluate>> getActivityEvaluateList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @RequestParam(name = "activityId")String activityId) {
        ResponseResult<IPage<ActivityEvaluate>> result = new ResponseResult<>();
        Page<ActivityInfo> page = new Page<>(pageNo, pageSize);
        IPage<ActivityEvaluate> evaluateList = scienceActivityEvaluateService.getActivityEvaluateList(page, activityId);
        result.setData(evaluateList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }

    @ApiOperation(value = "删除某条评论", notes = "删除某条评论接口")
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteEvaluateById(@RequestParam(name = "id")String id){
        boolean isSuccess = scienceActivityEvaluateService.removeById(id);
        return ResponseEntity.ok(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
    }

    @ApiOperation(value = "发表评论", notes = "发表评论接口")
    @PostMapping("/publish")
    public ResponseEntity<Integer> publishOneEvaluate(@RequestBody ActivityEvaluate activityEvaluate){
        boolean isSuccess =scienceActivityEvaluateService.save(activityEvaluate);
        return ResponseEntity.ok(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
    }
}
