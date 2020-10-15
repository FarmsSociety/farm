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
public class ExpertEvaluateDto implements Serializable {
    @ApiModelProperty(value = "评论人电话", required = true)
    private String phoneNum;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    @ApiModelProperty(value = "评论人姓名", required = true)
    private String name;
    @ApiModelProperty(value = "评论人头像url", required = true)
    private String  avatar;
    @ApiModelProperty(value = "审核", required = true)
    private String  verify;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评论时间", required = true)
    private Date date;
}
