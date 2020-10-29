package cn.doeon.farm.shop.common.util;

import lombok.Data;

/**
 * @ClassName： Msg.java
 * @Path： com.blog.utils.Msg.java
 * @Description：响应数据封装
 * @Author： hexy
 * @Date： 2020/4/13 11:30
 * @Reviser：
 */
@Data
public class Msg {

    private Integer code;

    private String message;

    private Object data = new Object();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    public static Msg error() {
        Msg result = new Msg();
        result.setCode(500);
        result.setMessage("error");
        return result;
    }

    public Msg add(Object value) {
        this.data = value;
        return this;
    }
}