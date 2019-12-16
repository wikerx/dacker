package com.scott.ds.limit;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName :AuthorityInterceptor
 * @Description :
 * @Author :Mr.薛
 * @Data :2019/12/16 0016 下午 1:54
 * @Version :V1.0
 * @Status : 编写
 **/
public class AuthorityInterceptor  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // ①:START 方法注解级拦截器
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        AuthRequired methodAnnotation = method.getAnnotation(AuthRequired.class);
        // 有 @AuthRequired 注解，需要认证
        if (methodAnnotation != null) {
//            拦截API请求头部   true 通过    false 拦截
            return Authentication.AuthenticationSample(request,response);
//            return true;
        }
        return true;
    }


}