package com.scott.ds.service;/**
 * Created by Administrator on 2019/11/7.
 */

import com.scott.ds.entity.SysUser;
import com.scott.ds.entity.UserAllEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName :SysUserService
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:46
 * @Version :V1.0
 * @Status : 编写
 **/
public interface SysUserService {

    /**
     * 级联查询所有用户信息
     * */
    List<UserAllEntity> selectAllUserMsg();

    /**
     * 插入数据库并返回主键id
     * @param record
     * @return
     */
    Long insertUserReturnId(SysUser record);

    /**
     * 根据账户信息查询用户信息
     * */
    List<UserAllEntity> selectByAccount(@Param("account") String account);


}
