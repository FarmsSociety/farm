
package cn.doeon.farm.shop.bean.app.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("活动招募对象")
@Data
public class WxactiveDto {

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "编号ID")
    private Long id;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "招募简介")
    private String intro;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "招募标题")
    private String title;

    @ApiModelProperty(value = "招募详情")
    @JsonView(WithContent.class)
    private String content;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "数据状态")
    private Integer status;

    public static interface NoContent{}

    public static interface WithContent extends NoContent{}

}
