package com.scott.ds.mapper;

import com.scott.ds.annotation.DataSource;
import com.scott.ds.entity.UserAllEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName :UserUnionMapper
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/11/7  12:00
 * @Version :V1.0
 * @Status : 编写
 **/
@DataSource
@Mapper
public interface UserUnionMapper {

    /**
     * 级联查询所有用户信息
     * */
    @Select("SELECT a.*,b.*,c.* FROM sys_user a LEFT JOIN sys_user_login b ON b.user_id = a.id LEFT JOIN sys_user_screct c ON c.user_id = a.id")
    @DataSource("master")
    List<UserAllEntity> selectAllUserMsg();

    /**
     * 根据账户信息查询用户信息
     * */
    @Select("SELECT a.*,b.*,c.* FROM sys_user a LEFT JOIN sys_user_login b ON b.user_id = a.id LEFT JOIN sys_user_screct c ON c.user_id = a.id WHERE c.account = #{account}")
    List<UserAllEntity> selectByAccount(@Param("account") String account);


}
