package cn.doeon.farm.shop.admin.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 设置虚拟路径，访问绝对路径下资源
 */
@Configuration
public class UploadConfig implements WebMvcConfigurer{
//    @Value("${file.staticAccessPath}")
//    private String staticAccessPath;
//    @Value("${file.uploadFolder}")
//    private String uploadFolder;
//    @Value("${upload.file-path-prefix}")
//    private String uploadedFilePathPrefix;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/tmp/**").addResourceLocations( "/root/tmp/");
    }
}
