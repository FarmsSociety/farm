package cn.doeon.farm.shop.bean.model.science;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("science_expert_evaluate")
public class ExpertEvaluate implements Serializable {

    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id自动生成，不需要传入")
    private String id;
    @ApiModelProperty(value = "专家ID", required = true)
    private String expertId;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "审核", required = true)
    private String verify;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评价时间", required = true)
    private Date date;
}
