package cn.doeon.farm.shop.scienceActivity.controller;

import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.ActivityInfo;
import cn.doeon.farm.shop.bean.model.science.Expert;
import cn.doeon.farm.shop.service.ScienceExpertService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hexiangyi on 2018/10/26.
 */
@RestController
@RequestMapping("/science/expert")
@Api(tags = "科技专家模块接口")
public class ScienceExpertController {

    @Autowired
    private ScienceExpertService scienceExpertService;

    /**
     * 获取专家列表测试接口
     * @return
     */
    @ApiOperation(value = "获取专家列表", notes = "获取专家列表接口")
    @GetMapping("/list")
    public ResponseEntity<IPage<Expert>> getExpertList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Expert> page = new Page<>(pageNo, pageSize);
        IPage<Expert> expertList = scienceExpertService.getExpertList(page);
        return ResponseEntity.ok(expertList);
    }

    /**
     * 新增专家接口
     * @return
     */
    @ApiOperation(value = "新增专家", notes = "新增专家接口")
    @PostMapping("/add")
    public ResponseEntity<Integer> addExpert(@RequestBody Expert expert) {
        boolean isSuccess = scienceExpertService.save(expert);
        return ResponseEntity.ok(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
    }

    /**
     * 通过ID获取专家信息
     * @return
     */
    @ApiOperation(value = "通过ID获取专家信息", notes = "通过ID获取专家信息接口")
    @GetMapping("/infoById")
    public ResponseEntity<Expert> getExpertInfoById(@RequestParam (name = "id") String id) {
        Expert expert = scienceExpertService.getById(id);
        return ResponseEntity.ok(expert);
    }


    /**
     * 通过姓名获取专家信息
     * @return
     */
    @ApiOperation(value = "通过姓名获取专家信息", notes = "通过姓名获取专家信息接口")
    @GetMapping("/infoByName")
    public ResponseEntity<Expert> getExpertInfoByName(@RequestParam (name = "name") String name) {
        Expert expert = scienceExpertService.getExpertInfoByName(name);
        return ResponseEntity.ok(expert);
    }



    /**
     * 修改专家信息接口
     * @return
     */
    @ApiOperation(value = "修改专家信息", notes = "修改专家信息接口")
    @PutMapping("/update")
    public ResponseEntity<Integer> updateExpert(@RequestBody Expert expert) {
        boolean isSuccess = scienceExpertService.updateById(expert);
        return ResponseEntity.ok(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
    }

    /**
     * 删除专家信息接口
     * @return
     */
    @ApiOperation(value = "删除专家信息", notes = "删除专家信息接口")
    @DeleteMapping("/update")
    public ResponseEntity<Integer> deleteExpert(@RequestParam (name = "id") String id) {
        boolean isSuccess = scienceExpertService.removeById(id);
        return ResponseEntity.ok(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
    }

}
