package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import com.tbtaobao.cloud.parameter.FindPersonInfoData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:16
 */
@Mapper
public interface PersonDao {

    public int create(@Param("parameter")FindPersonInfo parameter);

    public Person getPersonById(@Param("id") Integer id);

    int findPersonInfoLstCount(@Param("parameter")FindPersonInfo parameter);

    List<Person> findPersonInfoLst(@Param("page")Page page, @Param("parameter")FindPersonInfo parameter);

    int deletePersonInfo(@Param("id") Integer id);

    int updatePersonInfo(Person person);
}
