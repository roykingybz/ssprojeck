package com.royking.securitylogindb.service;

import com.royking.securitylogindb.entity.UserEntity;

public interface UserService {

    /**
     * 插入userEntity
     * @param userEntity
     * @return
     */
    public boolean insert(UserEntity userEntity);

    /**
     * 通过username查询userEntity
     * @param username
     * @return
     */
    public UserEntity getByUsername(String username);
}
