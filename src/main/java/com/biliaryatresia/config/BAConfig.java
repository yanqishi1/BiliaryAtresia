package com.biliaryatresia.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BAConfig implements WebMvcConfigurer {

    /**
     * 设置跨域访问
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        针对所有的请求
        registry.addMapping("/**")
//                允许来源
                .allowedOriginPatterns("*")
                .allowedHeaders(CorsConfiguration.ALL)
//                get、post等等都支持
                .allowedMethods(CorsConfiguration.ALL)
//                允许携带凭证
                .allowCredentials(true)
//                1小时内不需要再预检
//               （发OPTIONS请求，在正常的像get请求发送前，会向发送一个OPTIONS，检查后端接口）
                .maxAge(3600);
    }
}
