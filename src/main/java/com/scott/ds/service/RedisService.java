package com.scott.ds.service;/**
 * Created by Administrator on 2019/11/18.
 */

import com.scott.ds.entity.UserAllEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @InterfaceName :RedisService
 * @Description :redis的缓存接口
 * @Author :Mr.薛
 * @Data :2019/11/18  10:43
 * @Version :V1.0
 * @Status : 编写
 **/
public interface RedisService {
    /**
     *  先用id生成key，在用这个key查询redis中有无缓存到对应的值
     *  若无缓存，则执行方法selectById，并把方法返回的值缓存到redis
     *  若有缓存，则直接把redis缓存的值返回给用户，不执行方法
     */
//    @Cacheable(cacheNames="account", key="#account")
    public List<UserAllEntity> selectUserCacheByAccount(@Param("account")String account);

    /**
     * 清除缓存数据
     * */
    public boolean deletByCacheAccount(@Param("account")String account);

}
