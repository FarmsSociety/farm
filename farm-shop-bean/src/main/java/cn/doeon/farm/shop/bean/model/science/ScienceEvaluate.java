package cn.doeon.farm.shop.bean.model.science;

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
@ApiModel(description = "科技服务评价信息")
@TableName("science_service_evaluate")
public class ScienceEvaluate implements Serializable {
    private static final long serialVersionUID = 1573163052724307870L;

    @ApiModelProperty(value = "评论ID，自动生成，不需要传入")
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    @ApiModelProperty(value = "活动ID", required = true)
    private String serviceId;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评论时间", required = true)
    private Date date;
}
