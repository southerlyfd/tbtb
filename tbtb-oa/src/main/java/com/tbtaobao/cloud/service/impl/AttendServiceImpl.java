package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.basic.Page;
import com.tbtaobao.cloud.dao.AttendDao;
import com.tbtaobao.cloud.parameter.FindAttendInfo;
import com.tbtaobao.cloud.parameter.FindAttendInfoData;
import com.tbtaobao.cloud.service.AttendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：jhb
 * @date ：2020-06-07 12:30
 */
@Service
public class AttendServiceImpl implements AttendService {

    @Resource
    private AttendDao attendDao;

    @Override
    public int create(FindAttendInfo attendInfo) {
        return attendDao.create(attendInfo);
    }

    @Override
    public int delete(Integer attendId) {
        return attendDao.delete(attendId);
    }

    @Override
    public Page<FindAttendInfoData> findAttendInfoLst(FindAttendInfo parameter) {
        if (parameter.getCurrentPage() == null || parameter.getCurrentPage() <= 0) {
            parameter.setCurrentPage(1);
        }
        if (parameter.getOnePageCount() == null || parameter.getOnePageCount() <= 0) {
            parameter.setOnePageCount(10);
        }
        // 获取数据总数量
        Integer count = attendDao.findAttendInfoLstCount(parameter);
        Page<FindAttendInfoData> page = new Page<>(parameter.getCurrentPage(), count, parameter.getOnePageCount());
        if (count == 0) {
            return page;
        }
        // 计算分页
        List<FindAttendInfoData> dataLst = attendDao.findAttendInfoLst(page, parameter);
        if (dataLst == null || dataLst.size() == 0) {
            return page;
        }
        page.setList(dataLst);
        return page;
    }
}
