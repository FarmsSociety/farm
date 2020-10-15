package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@TableName("science_service")
@ApiModel
public class ScienceService implements Serializable {
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id自动生成，不需要传入")
    private String id;

    @ApiModelProperty(value = "活动名称", required = true)
    private String title;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", required = true)
    private String startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "截止时间", required = true)
    private String endTime;

    @ApiModelProperty(value = "活动内容", required = true)
    private String description;

    @ApiModelProperty(value = "活动发布者", required = true)
    private String publisher;

    @ApiModelProperty(value = "活动地址", required = true)
    private String addr;

    @ApiModelProperty(value = "联系电话", required = true)
    private String phone;

    @ApiModelProperty(value = "活动状态 0--未开始 1--进行中 2--结束 ", required = true)
    private String serviceStatus;

    @ApiModelProperty(value = "活动封面图片 ", required = true)
    private String iconUrl;

    @ApiModelProperty(value = "活动相册 ", required = true)
    private String imgUrl;

    @ApiModelProperty(value = "报名条件 0--所有人 1--vip会员 2--其它 ", required = true)
    private String conditions;

    @ApiModelProperty(value = "宣讲者", required = true)
    private String preacher;

    @ApiModelProperty(value = "宣讲者类型 0--普通人员 1--专家 2--教授", required = true)
    private String preacherIdentity;
}
