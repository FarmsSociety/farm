package cn.doeon.farm.shop.bean.dto;

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
@ApiModel
public class ActivityInfoDto implements Serializable {

    private static final long serialVersionUID = -747479774252087560L;

    @ApiModelProperty(value ="活动名称")
    private String title;
    @ApiModelProperty(value ="活动状态，0-未开始，1-进行中，2-结束")
    private String activityStatus;
    @ApiModelProperty(value ="查询时间YYYY-MM-DD")
    private String date;

}
