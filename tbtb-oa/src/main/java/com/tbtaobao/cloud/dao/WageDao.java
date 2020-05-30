package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.entities.Wage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:57
 */
@Mapper
public interface WageDao {

    int create(Wage wage);
}
