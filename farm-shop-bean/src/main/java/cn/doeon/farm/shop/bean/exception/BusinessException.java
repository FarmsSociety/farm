package cn.doeon.farm.shop.bean.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @path：com.blog.exception.BusinessException.java
 * @className：BusinessException.java
 * @description：业务异常处理
 * @author：tanyp
 * @dateTime：2020/7/11 11:52
 * @editNote：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private String msg;

}
