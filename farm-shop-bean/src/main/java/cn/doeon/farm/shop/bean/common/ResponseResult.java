package cn.doeon.farm.shop.bean.common;


import lombok.Data;

/**
 *
 * 通用返回结果
 *
 * @param <T>
 */
@Data
public class ResponseResult<T> {
    /**
     * 状态
     */
    private int status;
    /**
     * 描述
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}
