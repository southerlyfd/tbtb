package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entities.CommonResult;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：jhb
 * @date ：2020-04-12 21:49
 */
@RestController
@Slf4j
public class OaController {

    @Resource
    private PersonService personService;

    @PostMapping(value = "/oa/get")
    public CommonResult<Person> test(Long id){
//        Comparable result = new Comparable();

        log.info("查询开始");

        Person person = personService.getPersonById(id);
        System.out.println();
        if (person == null) {
            return new CommonResult<Person>(404, "查无此人", null);
        }

        return new CommonResult<Person>(200, "查询成功", person);
    }
}
