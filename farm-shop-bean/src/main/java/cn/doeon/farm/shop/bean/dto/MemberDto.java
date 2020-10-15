package cn.doeon.farm.shop.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class MemberDto implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "联系电话")
    private String phoneNum;
    @ApiModelProperty(value = "会员等级")
    private String leave;
}
