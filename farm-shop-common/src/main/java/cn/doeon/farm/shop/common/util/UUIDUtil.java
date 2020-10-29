package cn.doeon.farm.shop.common.util;

import java.util.UUID;

/**
 * @ClassName： UUIDUtil.java
 * @Path： com.blog.utils.UUIDUtil.java
 * @Description：UUID工具类
 * @Author： hexy
 * @Date： 2020/4/13 11:30
 * @Reviser：
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUUID(Integer len) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, len);
    }
}