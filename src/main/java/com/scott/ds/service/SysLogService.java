package com.scott.ds.service;
/**
 * Created by Administrator on 2019/11/7.
 */

import com.scott.ds.entity.SysLog;

/**
 * @InterfaceName :SysLogService
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  11:33
 * @Version :V1.0
 * @Status : 编写
 **/
public interface SysLogService {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);


}

