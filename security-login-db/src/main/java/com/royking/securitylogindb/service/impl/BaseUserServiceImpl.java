package com.royking.securitylogindb.service.impl;

import com.royking.securitylogindb.entity.UserEntity;
import com.royking.securitylogindb.mapper.UserMapper;
import com.royking.securitylogindb.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BaseUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private final static String ROLE_CONSTANT = "ROLE_USER";

    @Override
    public boolean insert(UserEntity userEntity) {
        String username = userEntity.getUsername();
        if (exist(username))
            return false;
        userEntity.setRoles(ROLE_CONSTANT);
        int result = userMapper.insert(userEntity);
        return  result == 1;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username){
        UserEntity userEntity = userMapper.selectByUsername(username);
        return (userEntity != null);
    }
}
