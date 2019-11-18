package com.scott.ds.mapper;

import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.SysUserLogin;
@DataSource//默认数据源
public interface SysUserLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserLogin record);

    int insertSelective(SysUserLogin record);

    SysUserLogin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserLogin record);

    int updateByPrimaryKey(SysUserLogin record);
}