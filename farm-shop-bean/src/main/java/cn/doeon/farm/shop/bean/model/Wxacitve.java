package cn.doeon.farm.shop.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("tz_wxactive")
@ApiModel
public class Wxacitve implements Serializable {
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
    private String createTime;

    @ApiModelProperty(value ="开始时间")
    private String startTime;

    @ApiModelProperty(value ="结束时间")
    private String endTime;

    @ApiModelProperty(value ="招募状态，1-等待开始，2-进行中，3-结束")
    private int activeStatus;

    @ApiModelProperty(value ="招募地址")
    private String address;

    @ApiModelProperty(value ="联系人")
    private String userName;

    @ApiModelProperty(value ="联系方式")
    private String userTel;

    @ApiModelProperty(value ="数据状态，0-删除，1-正常")
    private int status;
}
