package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.parameter.FindAttendInfo;
import com.tbtaobao.cloud.parameter.FindPersonInfoData;
import com.tbtaobao.cloud.service.AttendService;
import com.tbtaobao.cloud.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ：jhb
 * @date ：2020-06-06 22:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/attend")
public class AttendController {

    @Resource
    private AttendService attendService;

    @Resource
    private PersonService personService;


    /**
     * 增加考勤记录
     * @param attendInfo
     * @return
     */
    @RequestMapping("/createAttendInfo")
    public CommonResult<Map> createAttendInfo(FindAttendInfo attendInfo){
        CommonResult<Map> result = new CommonResult<Map>();
        if (attendInfo == null) {
            result.setCode(404);
            result.setMessage("信息不能为空");
            return result;
        }
        if (attendInfo.getEmployeeID() == null || attendInfo.getEmployeeID() <= 0) {
            result.setCode(404);
            result.setMessage("用户信息不能为空");
            return result;
        }
        FindPersonInfoData person = personService.getPersonById(attendInfo.getEmployeeID());
        if (person == null || person.getEmployeeID() == null) {
            result.setCode(404);
            result.setMessage("不存在该职员ID的职员信息，请核实");
            return result;
        }
        Integer data = attendService.create(attendInfo);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("新增信息失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("新增工资信息成功");
        return result;
    }


    /**
     * 删除考勤记录
     *
     * @param attendId
     * @return
     */
    @RequestMapping("/deleteAttendInfo")
    public CommonResult<Map> deleteAttendInfo(Integer attendId){
        CommonResult<Map> result = new CommonResult<Map>();
        if (attendId == null || attendId < 1) {
            result.setCode(404);
            result.setMessage("wageId字段不合法");
            return result;
        }
        Integer data = attendService.delete(attendId);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("删除考勤信息失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("删除成功");
        return result;
    }


    /**
     * 分页查询考勤记录
     *
     * @param attendInfo
     * @return
     */
    @RequestMapping("/findAttendInfoLst")
    public CommonResult<Page> findAttendInfoLst(FindAttendInfo attendInfo){
        CommonResult<Page> result = new CommonResult<Page>();
        Page data = attendService.findAttendInfoLst(attendInfo);
        result.setData(data);
        result.setCode(200);
        result.setMessage("查询成功");
        return result;
    }


    
}
