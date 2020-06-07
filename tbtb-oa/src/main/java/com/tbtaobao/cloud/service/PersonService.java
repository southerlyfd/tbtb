package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.parameter.FindPersonInfo;
import com.tbtaobao.cloud.parameter.FindPersonInfoData;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-04-12 22:10
 */
public interface PersonService {

    public int create(FindPersonInfo person);

    public FindPersonInfoData getPersonById(@Param("id") Integer id);

    Page<FindPersonInfoData> findPersonInfoLst(FindPersonInfo parameter);

    int deletePersonInfo(@Param("id") Integer id);

    int updatePersonInfo(Person person);
}
