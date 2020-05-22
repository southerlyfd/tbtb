package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.entities.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:16
 */
@Mapper
public interface PersonDao {

    public int create(Person person);

    public Person getPersonById(@Param("id") Integer id);
}
