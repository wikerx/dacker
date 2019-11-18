package com.scott.ds.service.impl;

import com.scott.ds.entity.UserAllEntity;
import com.scott.ds.mapper.UserUnionMapper;
import com.scott.ds.service.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName :RedisServiceImpl
 * @Description :redis缓存接口实现
 * @Author :Mr.薛
 * @Data :2019/11/18  10:44
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private UserUnionMapper userUnionMapper;


    /**
     *  先用id生成key，在用这个key查询redis中有无缓存到对应的值
     *  若无缓存，则执行方法selectById，并把方法返回的值缓存到redis
     *  若有缓存，则直接把redis缓存的值返回给用户，不执行方法
     */
    @Cacheable(cacheNames="users", key="#account")
    public List<UserAllEntity> selectUserCacheByAccount(@Param("account")String account){
        return userUnionMapper.selectByAccount(account);
    }

    /**
     * 清除缓存数据
     * */
    @CacheEvict(cacheNames ="users", key="#account")
    public boolean deletByCacheAccount(@Param("account")String account){
        return true;
    }

}
