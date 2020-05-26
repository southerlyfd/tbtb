package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.entities.UserInfo;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import com.tbtaobao.cloud.service.PersonService;
import com.tbtaobao.cloud.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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

    /**
     * 查询职员信息
     *
     * @param person
     * @return
     */
    @RequestMapping("/findPersonOne")
    public CommonResult<Person> findPersonInfo(Person person){
        CommonResult<Person> result = new CommonResult<Person>();

        if (person.getEmployeeID() == null || person.getEmployeeID() < 0) {
            result.setCode(404);
            result.setMessage("employeeID参数错误");
            return  result;
        }
        Person data = personService.getPersonById(person.getEmployeeID());
        if (data == null) {
            result.setCode(404);
            result.setMessage("没有该成员信息");
            return  result;
        }
        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(data);
        return result;
    }

    /**
     * 根据token查询职员信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping("/findPersonInfoByToken")
    public CommonResult<Person> findPersonInfoByToken(@RequestHeader String accessToken){
        CommonResult<Person> result = new CommonResult<Person>();

        UserInfo userInfo = userInfoService.findUserInfoByAccessToken(accessToken);
        if (userInfo == null) {
            result.setCode(404);
            result.setMessage("token 已失效！");
            return  result;
        }
        Person data = personService.getPersonById(userInfo.getUserId());
        if (data == null) {
            result.setCode(404);
            result.setMessage("没有该成员信息");
            return  result;
        }
        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(data);
        return result;
    }
    /*
     * 分页查询职员信息
     *
     * @param parameter
     * @return
     */
    @RequestMapping("/findPersonInfoLst")
    public CommonResult<Page> findPersonInfoLst(FindPersonInfo parameter){
        CommonResult<Page> result = new CommonResult<Page>();
        Page data = personService.findPersonInfoLst(parameter);
        result.setData(data);
        result.setCode(200);
        result.setMessage("查询成功");
        return result;
    }

    /**
     * 删除职员信息
     * @param employeeId
     * @return
     */
    @RequestMapping("/deletePersonInfo")
    public CommonResult<Map> deletePersonInfo(Integer employeeID){
        CommonResult<Map> result = new CommonResult<Map>();

        Integer data = personService.deletePersonInfo(employeeID);

        if (data == null || data == 0) {
            result.setCode(404);
            result.setMessage("删除失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("删除成功");
        return result;
    }

    /**
     * 更新职员信息
     *
     * @param person
     * @return
     */
    @RequestMapping("/updatePersonInfo")
    public CommonResult<Map> updatePersonInfo(Person person){
        CommonResult<Map> result = new CommonResult<Map>();

        if (person == null || person.getEmployeeID() == null || person.getEmployeeID() <= 0) {
            result.setCode(404);
            result.setMessage("参数为空");
            return result;
        }
        Integer data = personService.updatePersonInfo(person);

        if (data == null || data == 0) {
            result.setCode(404);
            result.setMessage("更新失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("更新成功");
        return result;
    }
}
