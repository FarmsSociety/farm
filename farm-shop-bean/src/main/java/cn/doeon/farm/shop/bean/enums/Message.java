package cn.doeon.farm.shop.bean.enums;

import lombok.Getter;

/**
 * @path：com.blog.enums.Message.java
 * @className：Message.java
 * @description：返回信息常量
 * @dateTime：2020/4/18 15:41
 * @editNote：
 */
@Getter
public enum Message {

    REQ_SUCCESS(1, "请求成功！"),
    REQ_ERROR(2, "请求失败！"),
    ERROR(3, "服务器异常！"),
    REQ_AUTHORITY(4, "您没有访问权限，请联系管理员！"),
    LOGIN_ERROR(5, "用户名称或密码错误！"),
    UPLOAD_NUll_ERROR(6,"请选择要上传的文件"),
    UPLOAD_SIZE_ERROR(7,"文件过大，请选择较小的文件"),
    UPLOAD_FORMAT_ERROR(8,"文件格式不支持，请重新选择"),
    ;

    private Integer code;

    private String msg;

    Message(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
