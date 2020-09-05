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
import java.util.Date;

@Data
@TableName("science_activity")
@ApiModel
public class ActivityInfo implements Serializable {

    private static final long serialVersionUID = -747479774252087560L;

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "活动ID, 自动生成，不需要传入")
    private String id;
    @ApiModelProperty(value ="活动名称", required = true)
    private String title;
    @ApiModelProperty(value ="活动开始时间", required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value ="活动结束时间", required = true)
    private Date endTime;
    @ApiModelProperty(value ="活动内容介绍", required = true)
    private String description;
    @ApiModelProperty(value ="活动发布者", required = true)
    private String publisher;
    @ApiModelProperty(value ="活动地址", required = true)
    private String addr;
    @ApiModelProperty(value ="联系电话", required = true)
    private String phone;
    @ApiModelProperty(value ="活动状态，0-未开始，1-进行中，2-结束", required = true)
    private int activityStatus;
    @ApiModelProperty(value ="活动图片地址，以逗号分隔", required = true)
    private String iconUrl;
    @ApiModelProperty(value ="报名条件，0-所有人，1-vip会员，2-其他", required = true)
    private int conditions;
    @ApiModelProperty(value ="宣讲者", required = true)
    private String preacher;
    @ApiModelProperty(value ="宣讲者身份，0-普通人员，1-专家，2-教授", required = true)
    private int preacherIdentity;
    @ApiModelProperty(value ="活动类型，0-科技服务，1-招募活动", required = true)
    private int activityType;
}
