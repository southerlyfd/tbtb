package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.parameter.FindMageInfo;
import com.tbtaobao.cloud.parameter.FindWageInfoData;
import com.tbtaobao.cloud.service.WageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.print.Paper;
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

    /**
     * 更新员工工资信息接口
     * @param wage
     * @return
     */
    @RequestMapping("/updateWageInfo")
    public CommonResult<Map> updateWageInfo(Wage wage){
        CommonResult<Map> result = new CommonResult<Map>();
        if (wage == null) {
            result.setCode(404);
            result.setMessage("更新信息为空");
            return result;
        }
        if (wage.getWageId() == null || wage.getWageId() < 1) {
            result.setCode(404);
            result.setMessage("wageId字段不合法");
            return result;
        }
        Integer data = wageService.update(wage);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("更新信息失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("更新成功");
        return result;
    }


    /**
     * 删除员工工资信息接口
     * @param wageId
     * @return
     */
    @RequestMapping("/deleteWageInfo")
    public CommonResult<Map> deleteWageInfo (Integer wageId){
        CommonResult<Map> result = new CommonResult<Map>();
        if (wageId == null || wageId < 1) {
            result.setCode(404);
            result.setMessage("wageId字段不合法");
            return result;
        }

        Integer data = wageService.delete(wageId);
        if (data == null || data <= 0) {
            result.setCode(404);
            result.setMessage("删除工资信息失败");
            return result;
        }
        result.setCode(200);
        result.setMessage("删除成功");
        return result;
    }

    /**
     * 分页查询员工工资信息接口
     * @param mageInfo
     * @return
     */
    @RequestMapping("/findWageInfoLst")
    public CommonResult<Page> findWageInfoLst(FindMageInfo mageInfo){
        CommonResult<Page> result = new CommonResult<Page>();
        Page data = wageService.findWageInfoLst(mageInfo);
        result.setData(data);
        result.setCode(200);
        result.setMessage("查询成功");
        return result;
    }

    /**
     * 查询工资详情
     *
     * @param wageId
     * @return
     */
    @RequestMapping("/findWageOne")
    public CommonResult<FindWageInfoData> findWageOne(Integer wageId){
        CommonResult<FindWageInfoData> result = new CommonResult<FindWageInfoData>();
        if (wageId == null || wageId <= 0) {
            result.setCode(404);
            result.setMessage("wageId参数不合法");
            return result;
        }
        FindWageInfoData data = wageService.findWageOne(wageId);
        if (data == null) {
            result.setCode(404);
            result.setMessage("员工工资信息不存在");
            return result;
        }
        result.setData(data);
        result.setCode(200);
        result.setMessage("查询成功");
        return result;
    }

}
