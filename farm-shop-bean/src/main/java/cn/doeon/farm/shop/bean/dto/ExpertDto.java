/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExpertDto implements Serializable {


    @ApiModelProperty(value = "专家名称")
    private String name;

    @ApiModelProperty(value = "专家电话")
    private String phone;

    @ApiModelProperty(value = "专家工作时间")
    private String date;

}
