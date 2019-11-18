package com.scott.ds.service.impl;

import com.scott.ds.entity.SysLog;
import com.scott.ds.mapper.SysLogMapper;
import com.scott.ds.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName :UserLogServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:33
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    public int deleteByPrimaryKey(Long id){return sysLogMapper.deleteByPrimaryKey(id);}

    public int insert(SysLog record){return sysLogMapper.insert(record);}

    public int insertSelective(SysLog record){return sysLogMapper.insertSelective(record);}

    public SysLog selectByPrimaryKey(Long id){return sysLogMapper.selectByPrimaryKey(id);}

    public int updateByPrimaryKeySelective(SysLog record){return sysLogMapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(SysLog record){return sysLogMapper.updateByPrimaryKey(record);}

}
