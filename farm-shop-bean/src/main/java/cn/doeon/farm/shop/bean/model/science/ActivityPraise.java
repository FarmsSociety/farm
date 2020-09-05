package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "点赞信息")
@TableName("science_activity_praise")
public class ActivityPraise implements Serializable {
    private static final long serialVersionUID = 7130923952545525538L;

    @ApiModelProperty(value = "ID自增主键")
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value = "活动ID", required = true)
    private String activityId;
    @ApiModelProperty(value = "点赞人ID", required = true)
    private String userId;
    @ApiModelProperty(value = "是否点赞，true-点赞，false-取消点赞", required = true)
    private boolean isPraise;
}
