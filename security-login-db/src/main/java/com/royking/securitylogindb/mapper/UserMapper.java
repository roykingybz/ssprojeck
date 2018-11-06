package com.royking.securitylogindb.mapper;

import com.royking.securitylogindb.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Insert("insert into(username,password,nickname,roles) values(#{username},#{password},#{nickname},#{roles})")
    public int insert(UserEntity userEntity);

    @Select("select * from user where username=#{username}")
    public UserEntity selectByUsername(@Param("username") String username);
}
