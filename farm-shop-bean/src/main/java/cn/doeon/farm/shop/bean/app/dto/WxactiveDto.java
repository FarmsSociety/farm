/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

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
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "详情")
    @JsonView(WithContent.class)
    private String content;

    @JsonView(NoContent.class)
    @ApiModelProperty(value = "发布时间")
    private Date createTime;

    public static interface NoContent{}

    public static interface WithContent extends NoContent{}

}
