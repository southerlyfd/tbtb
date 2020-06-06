package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Wage;
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

    int findWageInfoLstCount(@Param("parameter") Wage wage);

    List<Wage> findWageInfoLst(@Param("page") Page page, @Param("parameter") Wage wage);
}
