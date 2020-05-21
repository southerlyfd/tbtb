package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.entities.Person;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:10
 */
public interface PersonService {

    public int create(Person person);

    public Person getPersonById(@Param("id") Long id);

}
