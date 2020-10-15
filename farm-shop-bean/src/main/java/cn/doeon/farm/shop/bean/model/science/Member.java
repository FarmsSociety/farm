package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("science_member")
public class Member implements Serializable {
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id自动生成，不需要传入")
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
    @ApiModelProperty(value = "相册", required = true)
    private String imgUrl;
    @ApiModelProperty(value = "会员等级", required = true)
    private String leaves;
    @ApiModelProperty(value = "积分", required = true)
    private String integral;
    @ApiModelProperty(value = "报名状态0:未审核1：审核未通过2：审核已通过", required = true)
    private String signStatus;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "加入时间", required = true)
    private Date joinTime;
}
