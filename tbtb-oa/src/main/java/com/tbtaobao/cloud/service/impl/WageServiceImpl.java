package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.dao.WageDao;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.service.WageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:38
 */
@Service
public class WageServiceImpl implements WageService {

    @Resource
    private WageDao wageDao;

    @Override
    public int create(Wage wage) {
        return wageDao.create(wage);
    }

    @Override
    public int update(Wage wage) {
        return wageDao.update(wage);
    }

    @Override
    public int delete(Integer wageId) {
        return wageDao.delete(wageId);
    }

    @Override
    public Page<Wage> findWageInfoLst(Wage parameter) {
        return null;
    }
}
