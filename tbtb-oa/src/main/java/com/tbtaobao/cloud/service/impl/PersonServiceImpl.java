package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.dao.PersonDao;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import com.tbtaobao.cloud.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:14
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public int create(FindPersonInfo person) {
        if (person != null && person.getDate() != null) {
            person.setDates(new Date(person.getDate()));
        }
        return personDao.create(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personDao.getPersonById(id);
    }

    @Override
    public Page<Person> findPersonInfoLst(FindPersonInfo parameter) {
        if (parameter.getCurrentPage() == null || parameter.getCurrentPage() <= 0) {
            parameter.setCurrentPage(1);
        }
        if (parameter.getOnePageCount() == null || parameter.getOnePageCount() <= 0) {
            parameter.setOnePageCount(10);
        }
        // 获取数据总数量
        Integer count = personDao.findPersonInfoLstCount(parameter);
        Page<Person> page = new Page<>(parameter.getCurrentPage(), count, parameter.getOnePageCount());
        if (count == 0) {
            return page;
        }
        // 计算分页
        List<Person> dataLst = personDao.findPersonInfoLst(page, parameter);
        if (dataLst == null || dataLst.size() == 0) {
            return page;
        }
        page.setList(dataLst);
        return page;
    }

    @Override
    public int deletePersonInfo(Integer id) {
        return personDao.deletePersonInfo(id);
    }

    @Override
    public int updatePersonInfo(Person person) {
        return personDao.updatePersonInfo(person);
    }
}
