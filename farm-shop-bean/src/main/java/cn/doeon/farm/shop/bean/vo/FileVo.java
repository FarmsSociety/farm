package cn.doeon.farm.shop.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @path：com.blog.entity.vo.FileVo.java
 * @className：FileVo.java
 * @description：文件处理实体VO
 * @dateTime：2020/7/11 12:14
 * @editNote：
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 图片路径
     */
    private String imgUrl;
}
