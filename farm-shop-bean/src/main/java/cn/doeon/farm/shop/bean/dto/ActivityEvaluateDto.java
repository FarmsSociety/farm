package cn.doeon.farm.shop.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class ActivityEvaluateDto implements Serializable {
    @ApiModelProperty(value = "评论ID，自动生成，不需要传入")
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value = "活动ID", required = true)
    private String activityId;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    @ApiModelProperty(value = "评论人姓名", required = true)
    private String name;
    @ApiModelProperty(value = "评论人头像url", required = true)
    private String  avatar;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评论时间", required = true)
    private Date date;
}
