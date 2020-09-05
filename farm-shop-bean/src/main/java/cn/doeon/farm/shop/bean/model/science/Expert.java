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

    @ApiModelProperty(value = "专家类型 0-普通；1-专家； 2-教授",required=true)
    private Integer type;

    @ApiModelProperty(value = "专家擅长领域",required=true)
    private String area;

    @ApiModelProperty(value = "专家描述",required=true)
    private String description;

    @ApiModelProperty(value = "相关图片",required=true)
    private String iconUrl;
}
