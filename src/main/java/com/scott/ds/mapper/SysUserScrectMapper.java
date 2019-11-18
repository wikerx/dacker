package com.scott.ds.mapper;

import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.SysUserScrect;
import com.scott.ds.entity.SysUserScrectKey;
@DataSource//默认数据源
public interface SysUserScrectMapper {
    int deleteByPrimaryKey(SysUserScrectKey key);

    int insert(SysUserScrect record);

    int insertSelective(SysUserScrect record);

    SysUserScrect selectByPrimaryKey(SysUserScrectKey key);

    int updateByPrimaryKeySelective(SysUserScrect record);

    int updateByPrimaryKey(SysUserScrect record);
}