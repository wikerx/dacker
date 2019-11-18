package com.scott.ds.config;/**
 * Created by Administrator on 2019/11/7.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @AnnotationType :RecordLog
 * @Description :操作日志注解
 * @Author :Mr.薛
 * @Data :2019/11/7  14:37
 * @Version :V1.0
 * @Status : 编写
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RecordLog {
    String value() default "";
}

