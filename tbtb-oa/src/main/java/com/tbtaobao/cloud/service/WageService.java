package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.entities.Wage;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:31
 */
public interface WageService {

    int create(Wage wage);

    int update(Wage wage);

    int delete(Integer wageId);

    Page<Wage> findWageInfoLst(Wage parameter);
}
