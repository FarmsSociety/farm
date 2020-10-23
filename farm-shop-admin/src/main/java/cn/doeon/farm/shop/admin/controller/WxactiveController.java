/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.admin.controller;

import cn.doeon.farm.shop.bean.model.Wxactive;
import cn.doeon.farm.shop.service.WxactiveService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.doeon.farm.shop.common.util.PageParam;
import cn.doeon.farm.shop.common.annotation.SysLog;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * 活动招募
 *
 * @author hzm
 * @date
 */
@RestController
@AllArgsConstructor
@RequestMapping("/wx/wxactive")
public class WxactiveController {

    private final WxactiveService wxactiveService;

    /**
     * 分页查询
     *
     * @param page   分页对象
     * @param wxactive 公告管理
     * @return 分页数据
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<Wxactive>> getWxactivePage(PageParam<Wxactive> page, Wxactive wxactive) {
        IPage<Wxactive> WxactiveIPage = wxactiveService.page(page, new LambdaQueryWrapper<Wxactive>()
                .eq(wxactive.getStatus() != null, Wxactive::getStatus, wxactive.getStatus())
                .like(wxactive.getTitle() != null, Wxactive::getTitle, wxactive.getTitle()).orderByDesc(Wxactive::getCreateTime));
        return ResponseEntity.ok(WxactiveIPage);
    }


    /**
     * 通过id查询公告管理
     *
     * @param id id
     * @return 单个数据
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<Wxactive> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(wxactiveService.getById(id));
    }

    /**
     * 新增公告管理
     *
     * @param wxactive 公告管理
     * @return 是否新增成功
     */
    @SysLog("新增公告管理")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('wx:wxactive:save')")
    public ResponseEntity<Boolean> save(@RequestBody @Valid Wxactive wxactive) {
        if (wxactive.getStatus() == 1) {
            wxactive.setCreateTime(new Date());
        }
        wxactive.setCreateTime(new Date());
        wxactiveService.removeWxactiveList();
        return ResponseEntity.ok(wxactiveService.save(wxactive));
    }

    /**
     * 修改公告管理
     *
     * @param wxactive 公告管理
     * @return 是否修改成功
     */
    @SysLog("修改公告管理")
    @PutMapping
    @PreAuthorize("@pms.hasPermission('wx:wxactive:update')")
    public ResponseEntity<Boolean> updateById(@RequestBody @Valid Wxactive wxactive) {
        Wxactive oldWxactive = wxactiveService.getById(wxactive.getId());
        if (oldWxactive.getStatus() == 0 && wxactive.getStatus() == 1) {
            wxactive.setCreateTime(new Date());
        }
        wxactive.setStartTime(new Date());
        wxactive.setEndTime(new Date());
        wxactiveService.removeWxactiveList();
        wxactiveService.removeWxactiveById(wxactive.getId());
        return ResponseEntity.ok(wxactiveService.updateById(wxactive));
    }

    /**
     * 通过id删除公告管理
     *
     * @param id id
     * @return 是否删除成功
     */
    @SysLog("删除公告管理")
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('wx:wxactive:delete')")
    public ResponseEntity<Boolean> removeById(@PathVariable Long id) {
        wxactiveService.removeWxactiveList();
        wxactiveService.removeWxactiveById(id);
        return ResponseEntity.ok(wxactiveService.removeById(id));
    }
}
