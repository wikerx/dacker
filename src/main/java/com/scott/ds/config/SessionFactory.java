package com.scott.ds.config;

import com.scott.ds.entity.SysUser;
import com.scott.ds.entity.SysUserScrect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName :SessionFactory
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  15:18
 * @Version :V1.0
 * @Status : 编写
 **/
public class SessionFactory {
    private final static String USER_MSG = "USER_OBJ_MSG";
    /**
     * 添加session
     * */
    public void setSession(HttpServletRequest request, String key, Object object){
        HttpSession sesion = request.getSession();
        sesion.setAttribute(key,object);
    }

    /**
     * 添加用户session
     * */
    public void setUserSession(HttpServletRequest request, Object object){
        setSession(request,USER_MSG,object);
    }

    /**
     * 获取用户信息
     * */
    public SysUserScrect getUserSession(HttpServletRequest request){
        HttpSession sesion = request.getSession();
        SysUserScrect user = (SysUserScrect)sesion.getAttribute(USER_MSG);
        return user;
    }
}
