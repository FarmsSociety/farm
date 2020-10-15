package cn.doeon.farm.shop.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EvaluateDto implements Serializable {
    @ApiModelProperty(value ="专家id")
    private String expertId;
    @ApiModelProperty(value ="人员id")
    private String userId;

}
