package com.scott.ds.aop;
import com.scott.ds.config.RecordLog;
import com.scott.ds.config.SessionFactory;
import com.scott.ds.entity.SysLog;
import com.scott.ds.entity.SysUserScrect;
import com.scott.ds.service.impl.SysLogServiceImpl;
import com.scott.ds.utils.LocalIP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName :LogAspect
 * @Description :日志记录切面
 * @Author :Mr.薛
 * @Data :2019/11/7  14:38
 * @Version :V1.0
 * @Status : 编写
 **/
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogServiceImpl sysLogService;
    //自定义元注解
    @Pointcut("@annotation(com.scott.ds.config.RecordLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveLog(point, time);
        return result;
    }

    public void saveLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //对应的日志实体
        SysLog sysLog = new SysLog();
        //自定义元注解
        RecordLog logAnnotation = method.getAnnotation(RecordLog.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParams(params);
        }

//        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();//获取 shiro对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        SysUserScrect userScrect = new SessionFactory().getUserSession(request);
        sysLog.setUsername(userScrect.getAccount());
        sysLog.setUserId(userScrect.getUserId());
        //操作时长  毫秒
        sysLog.setTime((int)time);
        sysLog.setGmtCreate(new Date());
        sysLog.setIp(LocalIP.getLocalIP());
//        添加日志列表
        sysLogService.insertSelective(sysLog);

    }

}