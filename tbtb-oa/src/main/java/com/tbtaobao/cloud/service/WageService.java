package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.parameter.FindMageInfo;
import com.tbtaobao.cloud.parameter.FindWageInfoData;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:31
 */
public interface WageService {

    int create(Wage wage);

    int update(Wage wage);

    int delete(Integer wageId);

    Page<FindWageInfoData> findWageInfoLst(FindMageInfo mageInfo);

    FindWageInfoData findWageOne(Integer wageId);

}
