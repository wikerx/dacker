package com.scott.ds.controller;

import com.scott.ds.config.AnRateLimiter;
import com.scott.ds.service.RedisService;
import com.scott.ds.service.SysUserService;
import com.scott.ds.utils.Ognl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName :TestController
 * @Description :常规多数据源切换项目
 * @Author :Mr.薛
 * @Data :2019/11/18  10:10
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisService redisService;
    private static Log log = LogFactory.getLog(TestController.class);

    @AnRateLimiter(timeout = 1, timeunit = TimeUnit.SECONDS)
    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    public Object getAllUsers(){
        log.info("数据源测试... + 限流测试....");
        return sysUserService.selectAllUserMsg();
    }

    @AnRateLimiter(timeout = 1, timeunit = TimeUnit.SECONDS)
    @RequestMapping(value = "/selectUserCacheByAccount/{account}",method = RequestMethod.GET)
    public Object selectUserCacheByAccount(@PathVariable(value = "account",required = false) String account){
        if(Ognl.isEmpty(account)){
            return null;
        }else {
            return redisService.selectUserCacheByAccount(account);
        }
    }

    @AnRateLimiter(timeout = 1, timeunit = TimeUnit.SECONDS)
    @RequestMapping(value = "/delUserCacheByAccount/{account}",method = RequestMethod.GET)
    public Object delUserCacheByAccount(@PathVariable(value = "account",required = false) String account){
        if(Ognl.isEmpty(account)){
            return null;
        }else {
            return redisService.deletByCacheAccount(account);
        }
    }

}
