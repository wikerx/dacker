package com.scott.ds.controller;

import com.scott.ds.entity.UserAllEntity;
import com.scott.ds.service.impl.SysLogServiceImpl;
import com.scott.ds.service.impl.SysUserLoginServiceImpl;
import com.scott.ds.service.impl.SysUserScrectServiceImpl;
import com.scott.ds.service.impl.SysUserServiceImpl;
import com.scott.ds.utils.Ognl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName :LoginController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:34
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class LoginController {
    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private SysUserLoginServiceImpl sysUserLoginService;
    @Autowired
    private SysLogServiceImpl sysUserLogService;
    @Autowired
    private SysUserScrectServiceImpl sysUserScrectService;
    private static Log log = LogFactory.getLog(LoginController.class);

    /**
     * 模拟用户登陆
     * */
    @RequestMapping(value = "/login/{account}/{pwd}", method = RequestMethod.GET)
    public String login(@PathVariable(value = "account",required = false) String account,
                        @PathVariable(value = "pwd" ,required = false) String pwd,
                        HttpServletRequest request){
        if(Ognl.isEmpty(account) || Ognl.isEmpty(pwd)){
            return "FAIL";
        }
//        根据账户名查询账户信息
        UserAllEntity userAllEntity = (UserAllEntity)sysUserService.selectByAccount(account).get(0);
        return "SUCCESS";
    }



}
