package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.UserInfo;
import com.tbtaobao.cloud.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ：jhb
 * @date ：2020-05-20 19:53
 */

@RestController
@Slf4j
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    // 登陆
    @RequestMapping("/login")
    public CommonResult<Map> login(UserInfo userInfo){
        CommonResult<Map> result = new CommonResult<Map>();
        if (userInfo == null) {
            result.setCode(404);
            result.setMessage("请输入用户名及密码");
            return  result;
        }
        if (userInfo.getAccountNum() == null || "".equals(userInfo.getAccountNum())){
            result.setCode(404);
            result.setMessage("请输入用户名");
            return  result;
        }
        if (userInfo.getPassword() == null || "".equals(userInfo.getPassword())){
            result.setCode(404);
            result.setMessage("请输入密码");
            return  result;
        }
        // 查询
        CommonResult<Map> data = userInfoService.findUserInfo(userInfo);
        result.setCode(data.getCode());
        result.setMessage(data.getMessage());
        result.setData(data.getData());
        return result;
    }
}
