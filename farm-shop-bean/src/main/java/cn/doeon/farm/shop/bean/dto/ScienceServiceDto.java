package cn.doeon.farm.shop.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class ScienceServiceDto implements Serializable {

    private static final long serialVersionUID = -747479774252087560L;

    @ApiModelProperty(value ="活动名称")
    private String title;
    @ApiModelProperty(value ="查询时间YYYY-MM-DD")
    private String date;

}
