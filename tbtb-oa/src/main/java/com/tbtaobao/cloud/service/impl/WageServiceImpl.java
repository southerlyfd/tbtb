package com.tbtaobao.cloud.service.impl;

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
}
