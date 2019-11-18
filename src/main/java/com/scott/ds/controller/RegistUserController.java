package com.scott.ds.controller;

import com.scott.ds.config.RecordLog;
import com.scott.ds.config.SessionFactory;
import com.scott.ds.entity.SysUser;
import com.scott.ds.entity.SysUserScrect;
import com.scott.ds.entity.UserAllEntity;
import com.scott.ds.service.impl.SysLogServiceImpl;
import com.scott.ds.service.impl.SysUserLoginServiceImpl;
import com.scott.ds.service.impl.SysUserScrectServiceImpl;
import com.scott.ds.service.impl.SysUserServiceImpl;
import com.scott.ds.utils.EncryptionUtil;
import org.apache.catalina.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName :RegistUserController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:34
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class RegistUserController {
    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private SysUserLoginServiceImpl sysUserLoginService;
    @Autowired
    private SysLogServiceImpl sysUserLogService;
    @Autowired
    private SysUserScrectServiceImpl sysUserScrectService;
    private static Log log = LogFactory.getLog(RegistUserController.class);
    /**
     * 注册用户
     * */
    @RecordLog("用户注册")
    @Transactional
    @RequestMapping(value = "/registUser", method = RequestMethod.GET)
    public List<UserAllEntity> registUser(HttpServletRequest request){
        SysUser user = new SysUser();
        user.setAddress("南山区深南大道9966-XXXX");
        user.setAge(25);
        user.setArea("深圳市");
        user.setProvince("广东省");
        user.setCountry("China-中国");
        user.setLanguage("zh-cn");
        user.setUsername("scott");
        user.setSex(1);
        user.setStatus(1);
        sysUserService.insertUserReturnId(user);
//        注册失败，数回退
        if(null == user.getId() || user.getId().compareTo(new Long("0")) == 0){
            log.error("用户基础信息注册失败，数据回滚....");
            int m = 5/0;
        }else{
            log.info("用户基础信息注册成功，准备注入账户信息....");
            SysUserScrect screct = new SysUserScrect();
            screct.setUserId(user.getId());
            screct.setSalt(EncryptionUtil.getRandomString());
            screct.setAccount("admin");
            screct.setPassword(EncryptionUtil.encrySha1("123456",screct.getSalt()));

//            注册账户不能重复

            int m = sysUserScrectService.insertSelective(screct);
            if(m == 0){
                log.error("用户基础信息注册成功，但是用户账户信息注册失败，数据回滚....");
                int s = 5/0;
            }else{
                log.info("注册成功....");
                new SessionFactory().setUserSession(request,screct);
            }
        }
        return sysUserService.selectAllUserMsg();
    }


}
