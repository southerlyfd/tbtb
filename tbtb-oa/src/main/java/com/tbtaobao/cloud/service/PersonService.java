package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:10
 */
public interface PersonService {

    public int create(Person person);

    public Person getPersonById(@Param("id") Integer id);

    Page<Person> findPersonInfoLst(FindPersonInfo parameter);
}
