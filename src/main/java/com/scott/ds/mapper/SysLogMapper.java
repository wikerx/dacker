package com.scott.ds.mapper;

import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.SysLog;
@DataSource//默认数据源
public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}