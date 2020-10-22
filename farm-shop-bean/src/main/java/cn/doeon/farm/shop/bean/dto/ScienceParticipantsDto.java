package cn.doeon.farm.shop.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class ScienceParticipantsDto implements Serializable {
    private static final long serialVersionUID = -747479774252087560L;
    @ApiModelProperty(value ="人员名称")
    private String name;
    @ApiModelProperty(value ="人员id")
    private String id;
    @ApiModelProperty(value ="活动ID")
    private String serviceId;

}
