package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.parameter.FindAttendInfo;
import com.tbtaobao.cloud.parameter.FindAttendInfoData;

/**
 * @author ：jhb
 * @date ：2020-06-07 12:28
 */
public interface AttendService {

    int create(FindAttendInfo attendInfo);

    int delete(Integer attendId);

    Page<FindAttendInfoData> findAttendInfoLst(FindAttendInfo attendInfo);
}
