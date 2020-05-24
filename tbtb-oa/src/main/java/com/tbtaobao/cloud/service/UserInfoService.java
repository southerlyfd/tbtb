package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.UserInfo;

import java.util.Map;

/**
 * @author ：jhb
 * @date ：2020-05-20 20:25
 */
public interface UserInfoService {

    // 查询用户信息
    CommonResult<Map> findUserInfo(UserInfo userInfo);

    // 根据token查询用户信息
    UserInfo findUserInfoByAccessToken(String accessToken);
}
