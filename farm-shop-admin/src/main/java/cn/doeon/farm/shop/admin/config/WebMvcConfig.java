package cn.doeon.farm.shop.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 设置虚拟路径，访问绝对路径下资源
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations( "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations( "classpath:/META-INF/resources/webjars/");
    }
}
