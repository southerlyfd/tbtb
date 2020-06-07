package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.dao.PersonDao;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import com.tbtaobao.cloud.parameter.FindPersonInfoData;
import com.tbtaobao.cloud.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public FindPersonInfoData getPersonById(Integer id) {
        FindPersonInfoData result = new FindPersonInfoData();

        Person person = personDao.getPersonById(id);
        if (person == null) {
            return result;
        }
        result.setEmployeeID(person.getEmployeeID());
        result.setName(person.getName());
        result.setSex(person.getSex());
        result.setDate(person.getDate() == null ? 0 : person.getDate().getTime());
        result.setCity(person.getCity());
        result.setNation(person.getNation());
        result.setPolity(person.getPolity());
        result.setCulture(person.getCulture());
        result.setMarriage(person.getMarriage());
        result.setGraduate(person.getGraduate());
        result.setSpec(person.getSpec());
        result.setSpeci(person.getSpeci());
        result.setWtype(person.getWtype());
        result.setDuty(person.getDuty());
        result.setDepart(person.getDepart());
        result.setIdcard(person.getIdcard());
        result.setAddress(person.getAddress());
        result.setPostcode(person.getPostcode());
        result.setHomePhone(person.getHomePhone());
        result.setMobile(person.getMobile());
        result.setEmail(person.getEmail());
        result.setResume(person.getResume());
        result.setPhoto(person.getPhoto());
        return result;
    }

    @Override
    public Page<FindPersonInfoData> findPersonInfoLst(FindPersonInfo parameter) {
        if (parameter.getCurrentPage() == null || parameter.getCurrentPage() <= 0) {
            parameter.setCurrentPage(1);
        }
        if (parameter.getOnePageCount() == null || parameter.getOnePageCount() <= 0) {
            parameter.setOnePageCount(10);
        }
        // 获取数据总数量
        Integer count = personDao.findPersonInfoLstCount(parameter);
        Page<FindPersonInfoData> page = new Page<>(parameter.getCurrentPage(), count, parameter.getOnePageCount());
        if (count == 0) {
            return page;
        }
        // 计算分页
        List<Person> data = personDao.findPersonInfoLst(page, parameter);
        if (data == null || data.size() == 0) {
            return page;
        }
        List<FindPersonInfoData> dataLst = new ArrayList<>();
        for (Person person: data) {
            FindPersonInfoData result = new FindPersonInfoData();
            result.setEmployeeID(person.getEmployeeID());
            result.setName(person.getName());
            result.setSex(person.getSex());
            result.setDate(person.getDate() == null ? 0 : person.getDate().getTime());
            result.setCity(person.getCity());
            result.setNation(person.getNation());
            result.setPolity(person.getPolity());
            result.setCulture(person.getCulture());
            result.setMarriage(person.getMarriage());
            result.setGraduate(person.getGraduate());
            result.setSpec(person.getSpec());
            result.setSpeci(person.getSpeci());
            result.setWtype(person.getWtype());
            result.setDuty(person.getDuty());
            result.setDepart(person.getDepart());
            result.setIdcard(person.getIdcard());
            result.setAddress(person.getAddress());
            result.setPostcode(person.getPostcode());
            result.setHomePhone(person.getHomePhone());
            result.setMobile(person.getMobile());
            result.setEmail(person.getEmail());
            result.setResume(person.getResume());
            result.setPhoto(person.getPhoto());
            dataLst.add(result);
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
