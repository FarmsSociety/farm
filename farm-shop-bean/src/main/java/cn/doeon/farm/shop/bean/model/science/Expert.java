/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("science_expert")
public class Expert implements Serializable {

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id自动生成，不需要传入")
    private String id;
    @ApiModelProperty(value = "专家名称",required=true)
    private String name;

    @ApiModelProperty(value = "专家电话",required=true)
    private String phone;

    @ApiModelProperty(value = "专家类型等级 0-普通；1-专家； 2-教授",required=true)
    private Integer type;

    @ApiModelProperty(value = "专家擅长方向领域",required=true)
    private String area;

    @ApiModelProperty(value = "专家头像",required=true)
    private String avatar;

    @ApiModelProperty(value = "专家简介",required=true)
    private String description;

    @ApiModelProperty(value = "专家图册",required=true)
    private String iconUrl;
    //增加地址
    @ApiModelProperty(value = "专家地址",required=true)
    private String address;

    @ApiModelProperty(value = "专家详情",required=true)
    private String expertDetails;

    @ApiModelProperty(value = "专家工作开始时间",required=true)
    private Date startTime;

    @ApiModelProperty(value = "专家工作截止时间",required=true)
    private Date endTime;
}
