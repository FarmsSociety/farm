package cn.doeon.farm.shop.bean.exception;

/**
 * @path：com.blog.constant.Constants.java
 * @className：Constants.java
 * @description：常量
 * @dateTime：2020/6/21 22:51
 * @editNote：
 */
public class Constants {

    /**
     * 文章分类
     * 奇闻杂谈:0
     */
    public static final Integer ARTICLE_CLASSIFY_ANECDOTES = 0;

    public static final String HTTP = "http://";

    /**
     * 项目CONTEXT_PATH
     */
    public static final String CONTEXT_PATH = "/";

    /**
     * 文件映射地址
     */
    public static final String UPLOAD = "upload/";

    public static final String SUCCESS = "操作成功";

    public static final String ERROR = "操作失败";

    public static final String FILENOTEXIST = "文件不存在";

    public static final String OLD_PASSWORD_ERROR = "原始密码有误";

    /**
     * 统一异常处理
     */
    public static final String ERROR_EXCEPTION = "系统繁忙，请稍后再试！";

    /**
     * 分页参数：默认
     */
    public static final Integer PAGE_START = 0;
    /**
     * 分页参数：页大小（默认）
     */
    public static final Integer PAGE_SIZE = 10;

    /**
     * 默认图片
     */
    public static final String IMG_NAME= "blog.jpg";
}
