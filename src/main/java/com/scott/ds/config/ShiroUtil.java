package com.scott.ds.config;
import com.scott.ds.entity.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * @ClassName :ShiroUtil
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  15:00
 * @Version :V1.0
 * @Status : 编写
 **/
public class ShiroUtil {

        public static SysUser getUser(){
            SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            return user;
        }

}
