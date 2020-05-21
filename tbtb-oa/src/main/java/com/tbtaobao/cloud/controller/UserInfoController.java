package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.entities.UserInfo;
import com.tbtaobao.cloud.service.PersonService;
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
    private     UserInfoService         userInfoService;

    @Resource
    private     PersonService           personService;

    /**
     * 管理员登陆
     * @param userInfo
     * @return
     */
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


    /**
     * 新增职员信息
     *
     * @param person
     * @return
     */
    @RequestMapping("/createPersonInfo")
    public CommonResult<Map> createPersonInfo(Person person){
        CommonResult<Map> result = new CommonResult<Map>();
        if (person.getName() == null || "".equals(person.getName())) {
            result.setCode(404);
            result.setMessage("请输入职工姓名");
            return  result;
        }
        Integer data = personService.create(person);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("新增信息失败");
            return  result;
        }
        result.setCode(200);
        result.setMessage("添加成功");
        return result;
    }
}
