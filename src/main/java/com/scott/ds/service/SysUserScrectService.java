package com.scott.ds.service;/**
 * Created by Administrator on 2019/11/7.
 */

import com.scott.ds.entity.SysUserScrect;
import com.scott.ds.entity.SysUserScrectKey;

/**
 * @InterfaceName :SysUserScrectService
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:46
 * @Version :V1.0
 * @Status : 编写
 **/
public interface SysUserScrectService {

    int deleteByPrimaryKey(SysUserScrectKey key);

    int insert(SysUserScrect record);

    int insertSelective(SysUserScrect record);

    SysUserScrect selectByPrimaryKey(SysUserScrectKey key);

    int updateByPrimaryKeySelective(SysUserScrect record);

    int updateByPrimaryKey(SysUserScrect record);

}
