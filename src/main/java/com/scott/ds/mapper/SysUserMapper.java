package com.scott.ds.mapper;

import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.SysUser;
@DataSource//默认数据源
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 插入数据库并返回主键id
     * @param record
     * @return
     */
    Long insertUserReturnId(SysUser record);

}