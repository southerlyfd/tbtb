package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.entities.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-05-20 20:28
 */
@Mapper
public interface UserInfoDao {


    UserInfo findUserInfo(@Param("accountNum") String accountNum, @Param("password") String password);

    int updateUserInfo(@Param("userInfo")UserInfo userInfo);
}
