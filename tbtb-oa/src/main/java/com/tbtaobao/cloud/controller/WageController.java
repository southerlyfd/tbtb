package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.service.WageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:30
 */
@RestController
@Slf4j
@RequestMapping(value = "/wage")
public class WageController {


    @Resource
    private WageService wageService;


    /**
     * 新增工资信息
     *
     * @param wage
     * @return
     */
    @RequestMapping("/createWage")
    public CommonResult<Map> createWage(Wage wage){

        CommonResult<Map> result = new CommonResult<Map>();
        if (wage == null) {
            result.setCode(404);
            result.setMessage("信息不能为空");
            return result;
        }
        if (wage.getEmployeeID() == null || wage.getEmployeeID() <= 0) {
            result.setCode(404);
            result.setMessage("用户信息不能为空");
            return result;
        }
        Integer data = wageService.create(wage);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("新增信息失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("新增工资信息成功");
        return result;
    }

    // 更新员工工资信息接口



    // 删除员工工资信息接口



    // 分页查询员工工资信息接口



}
