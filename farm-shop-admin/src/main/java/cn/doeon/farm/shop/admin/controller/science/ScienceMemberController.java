package cn.doeon.farm.shop.admin.controller.science;

import cn.doeon.farm.shop.bean.common.ResponseResult;
import cn.doeon.farm.shop.bean.common.ResultMsg;
import cn.doeon.farm.shop.bean.dto.MemberDto;
import cn.doeon.farm.shop.bean.enums.ResultStatus;
import cn.doeon.farm.shop.bean.model.science.Member;
import cn.doeon.farm.shop.service.ScienceMemberService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author hexiangyi on 2018/10/26.
 */
@RestController
@RequestMapping("/science/member")
@Api(tags = "会员风采模块接口")
public class ScienceMemberController {

    @Autowired
    private ScienceMemberService scienceMemberService;

    /**
     * 获取会员列表测试接口
     * @return
     */
    @ApiOperation(value = "获取会员列表", notes = "获取会员列表接口")
    @GetMapping("/list")
    public ResponseResult<IPage<Member>> getMemberList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       MemberDto memberDto) {
        ResponseResult<IPage<Member>> result = new ResponseResult<>();
        Page<Member> page = new Page<>(pageNo, pageSize);
        IPage<Member> expertList = scienceMemberService.getMemberList(page,memberDto);
        result.setData(expertList);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }



    /**
     * 通过ID获取会员详情
     * @return
     */
    @ApiOperation(value = "通过ID会员详情", notes = "通过ID会员详情")
    @GetMapping("/infoById")
    public ResponseResult<Member> getMemberInfoById(@RequestParam (name = "id") String id) {
        ResponseResult<Member> result = new ResponseResult<>();
        Member expert = scienceMemberService.getById(id);
        result.setData(expert);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }


    /**
     * 通过姓名获取会员
     * @return
     */
    @ApiOperation(value = "通过姓名获取会员", notes = "通过姓名获取会员")
    @GetMapping("/infoByName")
    public ResponseResult<Member> getMemberInfoByName(@RequestParam (name = "name") String name) {
        Member member = scienceMemberService.getMemberInfoByName(name);
        ResponseResult<Member> result = new ResponseResult<>();
        result.setData(member);
        result.setStatus(ResultStatus.SUCCESS.value());
        result.setMsg(ResultMsg.MSG_SUCCESS);
        return result;
    }



    /**
     * 修改会员信息修改接口
     * @return
     */
    @ApiOperation(value = "会员信息修改", notes = "会员信息修改")
    @PutMapping("/update")
    public ResponseResult updateMember(@RequestBody Member member) {
        boolean isSuccess = scienceMemberService.updateById(member);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }

    /**
     * 会员删除接口
     * @return
     */
    @ApiOperation(value = "会员删除", notes = "会员删除")
    @DeleteMapping("/delete")
    public ResponseResult deleteExpert(@RequestParam (name = "id") String id) {
        boolean isSuccess = scienceMemberService.removeById(id);
        ResponseResult result = new ResponseResult();
        result.setStatus(isSuccess ? ResultStatus.SUCCESS.value() : ResultStatus.FAIL.value());
        result.setMsg(isSuccess ? ResultMsg.MSG_SUCCESS : ResultMsg.MSG_FAIL);
        return result;
    }



}
