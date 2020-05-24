package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.dao.UserInfoDao;
import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.UserInfo;
import com.tbtaobao.cloud.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ：jhb
 * @date ：2020-05-20 20:26
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public CommonResult<Map> findUserInfo(UserInfo userInfo) {
        CommonResult<Map> result = new CommonResult<Map>();
        Map map = new HashMap();

        UserInfo data = userInfoDao.findUserInfo(userInfo.getAccountNum(), userInfo.getPassword());
        if (data == null) {
            result.setCode(404);
            result.setMessage("请输入正确的账号和密码");
            return result;
        }
        String token = UUID.randomUUID().toString().replaceAll("-","");
        // 更新数据库
        UserInfo parameter = new UserInfo();
        parameter.setUserId(data.getUserId());
        parameter.setAccessToken(token);
        parameter.setUpdateTime(new Date());
        userInfoDao.updateUserInfo(parameter);
        map.put("token", token);
        result.setData(map);
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    @Override
    public UserInfo findUserInfoByAccessToken(String accessToken) {
        return userInfoDao.findUserInfoToken(accessToken);
    }
}
