package com.scott.ds;

import com.scott.ds.aop.DynamicDataSourceAnnotationAdvisor;
import com.scott.ds.aop.DynamicDataSourceAnnotationInterceptor;
import com.scott.ds.register.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@MapperScan("com.scott.ds.mapper")
@SpringBootApplication
//开始事务管理
@EnableTransactionManagement
//开启注解驱动的缓存管理
@EnableCaching
//开启定时任务扫描
@EnableScheduling
public class DackerApplication {
    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }
    public static void main(String[] args) {
        SpringApplication.run(DackerApplication.class, args);
    }
}
