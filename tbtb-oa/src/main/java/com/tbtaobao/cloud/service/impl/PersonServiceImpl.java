package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.dao.PersonDao;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:14
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public int create(Person person) {
        return personDao.create(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }
}
