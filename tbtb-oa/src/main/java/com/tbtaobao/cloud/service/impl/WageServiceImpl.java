package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.dao.WageDao;
import com.tbtaobao.cloud.entities.Person;
import com.tbtaobao.cloud.entities.Wage;
import com.tbtaobao.cloud.parameter.FindMageInfo;
import com.tbtaobao.cloud.parameter.FindWageInfoData;
import com.tbtaobao.cloud.service.WageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        // 判断是否存在工资信息
        int isWhereAre = wageDao.findWageIsThere(wage);
        if (isWhereAre > 0) {
            return 1;
        }
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
    public Page<FindWageInfoData> findWageInfoLst(FindMageInfo parameter) {

        if (parameter.getCurrentPage() == null || parameter.getCurrentPage() <= 0) {
            parameter.setCurrentPage(1);
        }
        if (parameter.getOnePageCount() == null || parameter.getOnePageCount() <= 0) {
            parameter.setOnePageCount(10);
        }
        // 获取数据总数量
        Integer count = wageDao.findWageInfoLstCount(parameter);
        Page<FindWageInfoData> page = new Page<>(parameter.getCurrentPage(), count, parameter.getOnePageCount());
        if (count == 0) {
            return page;
        }
        // 计算分页
        List<FindWageInfoData> dataLst = wageDao.findWageInfoLst(page, parameter);
        if (dataLst == null || dataLst.size() == 0) {
            return page;
        }
        page.setList(dataLst);
        return page;
    }

    @Override
    public FindWageInfoData findWageOne(Integer wageId) {
        return wageDao.findWageOne(wageId);
    }
}
