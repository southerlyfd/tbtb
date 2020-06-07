package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.parameter.FindAttendInfo;
import com.tbtaobao.cloud.parameter.FindAttendInfoData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：jhb
 * @date ：2020-06-07 13:08
 */
@Mapper
public interface AttendDao {

    int create(@Param("parameter")FindAttendInfo parameter);

    int delete(@Param("attendId") Integer attendId);

    int findAttendInfoLstCount(@Param("parameter") FindAttendInfo parameter);

    List<FindAttendInfoData> findAttendInfoLst(@Param("page") Page page, @Param("parameter") FindAttendInfo parameter);

}
