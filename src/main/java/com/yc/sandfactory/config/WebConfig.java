package com.yc.sandfactory.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.nutz.dao.impl.NutDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author: yc
 * @Date: 2017-7-28 17:38
 * @EnableWebMvc == <mvc:annotation-driven />
 * @ComponentScan == < context:component-scan base-package= "org.rest" />
 * @EnableAspectJAutoProxy == <aop:aspectj-autoproxy>
 * @ImportResource == <import resource=”classpath*:/rest_config.xml” />
 *
 * < context:property-placeholder location= "classpath:persistence.properties,
 * classpath:web.properties" ignore-unresolvable=
 */
@Configuration
//@PropertySource({"classpath:system.properties"})
@ImportResource({"classpath*:spring-dao.xml"})
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public NutDao nutDao(DataSource dataSource) {
    return new NutDao(dataSource);
  }

  @Bean
  public DataSource dataSource() {
    return new DruidDataSource();
  }
}
