package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "活动评论点赞信息")
@TableName("science_activity_evaluate")
public class ActivityEvaluate implements Serializable {
    private static final long serialVersionUID = 1573163052724307870L;

    @ApiModelProperty(value = "评论ID，自动生成，不需要传入")
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value = "活动ID", required = true)
    private String activityId;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
}
