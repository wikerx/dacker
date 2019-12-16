package com.scott.ds.controller.api;

import com.scott.ds.config.AnRateLimiter;
import com.scott.ds.config.RecordLog;
import com.scott.ds.limit.AuthRequired;
import com.scott.ds.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName :Api
 * @Description : 需要限流和鉴权的API
 * @Author :Mr.薛
 * @Data :2019/12/16 0016 下午 3:59
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
@RequestMapping(value = "/api/online")
public class Api {
    @Autowired
    private SysUserService userService;

    /**
     * 鉴权API的调用必须符合设定规则
     * header中 Authentication 不为空
     * */
    @RecordLog("鉴权接口调用")
    @RequestMapping(value = "auth",method = RequestMethod.POST)
    @AnRateLimiter(timeout = 1, timeunit = TimeUnit.SECONDS,permitsPerSecond = 10)
    @AuthRequired
    public Object authApi(){
        return "auth request Pass!";
    }
}
