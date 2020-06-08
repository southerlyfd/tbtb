package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.parameter.FindMageInfo;
import com.tbtaobao.cloud.parameter.FindWageInfoData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:57
 */
@Mapper
public interface WageDao {

    int create(Wage wage);

    int update(Wage wage);

    int delete(@Param("wageId") Integer wageId);

    int findWageInfoLstCount(@Param("parameter") FindMageInfo parameter);

    List<FindWageInfoData> findWageInfoLst(@Param("page") Page page, @Param("parameter") FindMageInfo parameter);

    FindWageInfoData findWageOne(@Param("wageId") Integer wageId);

    int findWageIsThere(Wage wage);
}
