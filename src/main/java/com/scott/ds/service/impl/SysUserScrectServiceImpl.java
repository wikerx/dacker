package com.scott.ds.service.impl;

import com.scott.ds.entity.SysUserScrect;
import com.scott.ds.entity.SysUserScrectKey;
import com.scott.ds.mapper.SysUserScrectMapper;
import com.scott.ds.service.SysUserScrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName :SysUserScrectServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:46
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class SysUserScrectServiceImpl implements SysUserScrectService {
    @Autowired
    private SysUserScrectMapper sysUserScrectMapper;

    public int deleteByPrimaryKey(SysUserScrectKey key){return sysUserScrectMapper.deleteByPrimaryKey(key);}

    public int insert(SysUserScrect record){return sysUserScrectMapper.insert(record);}

    public int insertSelective(SysUserScrect record){return sysUserScrectMapper.insertSelective(record);}

    public SysUserScrect selectByPrimaryKey(SysUserScrectKey key){return sysUserScrectMapper.selectByPrimaryKey(key);}

    public int updateByPrimaryKeySelective(SysUserScrect record){return sysUserScrectMapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(SysUserScrect record){return sysUserScrectMapper.updateByPrimaryKey(record);}

}
