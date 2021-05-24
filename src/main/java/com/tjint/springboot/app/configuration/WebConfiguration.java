package com.tjint.springboot.app.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.sql.DataSource;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    HandlerInterceptor handlerInterceptor;

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
            {"classpath:/static/", "classpath:/public/", "classpath:/", "classpath:/resources/", "classpath:/META-INF/resources/"
                    , "classpath:/META-INF/resources/webjars/"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:28080", "http://localhost:8080")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor)
                .addPathPatterns("/api/auth/**").
        excludePathPatterns(
                "/v2/api-docs",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/api/auth/authenticate"
        );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/main/mainPage");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource[] arrResource = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/**/*.xml");

        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(arrResource);
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
}
