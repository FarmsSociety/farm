package cn.doeon.farm.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("tz_xactive")
@ApiModel
public class Wxactive implements Serializable {
    @TableId
    @ApiModelProperty(value = "编号ID")
    private Long id;

    @ApiModelProperty(value ="招募标题", required = true)
    private String title;

    @ApiModelProperty(value ="招募简介", required = true)
    private String intro;

    @ApiModelProperty(value ="招募详情")
    private String content;

    @ApiModelProperty(value ="创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value ="开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty(value ="结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty(value ="招募状态，1-等待开始，2-进行中，3-结束")
    private Integer activeStatus;

    @ApiModelProperty(value ="招募地址")
    private String address;

    @ApiModelProperty(value ="联系人")
    private String userName;

    @ApiModelProperty(value ="联系方式")
    private String userTel;

    @ApiModelProperty(value ="数据状态，0-删除，1-正常")
    private Integer status;
}
