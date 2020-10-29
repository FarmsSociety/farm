package cn.doeon.farm.shop.bean.exception;

import cn.doeon.farm.shop.common.util.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @path：com.blog.exception.GlobalException.java
 * @className：GlobalException.java
 * @description：全局异常处理
 * @dateTime：2020/7/11 11:50
 * @editNote：
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Msg handle(Exception e) {
        if (e instanceof BusinessException) {
            log.error("业务逻辑处理异常：{}", ((BusinessException) e).getMsg());
            e.printStackTrace();
            return Msg.error().add(((BusinessException) e).getMsg());
        }
        log.error("系统异常：{}", e);
        return Msg.error().add(Constants.ERROR_EXCEPTION);
    }
}
