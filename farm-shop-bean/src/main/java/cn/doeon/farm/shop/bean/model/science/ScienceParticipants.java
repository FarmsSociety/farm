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
@ApiModel(description = "科技服务参与报名人员")
@TableName("science_service_participants")
public class ScienceParticipants implements Serializable {

    @ApiModelProperty(value = "活动报名人ID，自动生成，不需要传入")
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value = "姓名", required = true)
    private String name;
    @ApiModelProperty(value = "0-男；1-女", required = true)
    private String sex;
    @ApiModelProperty(value = "联系电话", required = true)
    private String phoneNum;
    @ApiModelProperty(value = "身份证号", required = true)
    private String identity;
    @ApiModelProperty(value = "联系地址", required = true)
    private String addr;
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;
    @ApiModelProperty(value = "头像", required = true)
    private String avatar;
    @ApiModelProperty(value = "服务id", required = true)
    private String serviceId;
    @ApiModelProperty(value = "备注信息", required = false)
    private String remark;
    @ApiModelProperty(value = "报名状态0:未审核1：审核未通过2：审核已通过", required = true)
    private String signStatus;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报名时间", required = true)
    private Date signTime;
}