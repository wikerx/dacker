package com.scott.ds.service.impl;

import com.scott.ds.entity.SysUser;
import com.scott.ds.entity.UserAllEntity;
import com.scott.ds.mapper.SysUserMapper;
import com.scott.ds.mapper.UserUnionMapper;
import com.scott.ds.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName :SysUserServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:46
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private UserUnionMapper userUnionMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 级联查询所有用户信息
     * */
    public List<UserAllEntity> selectAllUserMsg(){return userUnionMapper.selectAllUserMsg();}

    /**
     * 插入数据库并返回主键id
     * @param record
     * @return
     */
    public Long insertUserReturnId(SysUser record){return sysUserMapper.insertUserReturnId(record);}

    /**
     * 根据账户信息查询用户信息
     * */
    public List<UserAllEntity> selectByAccount(@Param("account") String account){return userUnionMapper.selectByAccount(account);}

}
