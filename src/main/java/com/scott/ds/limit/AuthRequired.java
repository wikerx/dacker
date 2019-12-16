package com.scott.ds.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要登录验证的Controller的方法上使用此注解
 */
// 可用在方法名上
@Target({ElementType.METHOD})
// 运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRequired {

}