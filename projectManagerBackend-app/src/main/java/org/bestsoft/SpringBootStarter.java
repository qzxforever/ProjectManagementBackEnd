package org.bestsoft;

import org.bestsoft.jpa.base.BaseRepositoryFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication(scanBasePackages = "org.bestsoft")
//@PropertySource(value = {"file:${APP_HOME_CONF}/projectManagerBackend-app/conf.properties"}
//        , ignoreResourceNotFound = false)
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@EnableCaching
public class SpringBootStarter extends SpringBootServletInitializer {

    private final static Logger logger = LoggerFactory.getLogger(SpringBootStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
        logger.info("Application start.");
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
}
