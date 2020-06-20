package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.dao.DictionaryDao;
import com.tbtaobao.cloud.entity.DictionaryInfo;
import com.tbtaobao.cloud.service.DictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 19:53
 * @description：
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryDao dictionaryDao;


    @Override
    public List<DictionaryInfo> queryDictionary(DictionaryInfo dictionaryInfo) {
        List<DictionaryInfo> dictionaryInfos = dictionaryDao.queryDictionaryInfo(dictionaryInfo);
        if (dictionaryInfos == null || dictionaryInfos.isEmpty()) {
            return null;
        }
        for (DictionaryInfo dictInfo : dictionaryInfos) {
            dictInfo.setDictionaryDetailList(dictionaryDao.queryDictionaryDetail(dictInfo));
        }
        return dictionaryInfos;
    }

    @Override
    @Transactional
    public void addDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryDao.addDictionaryInfo(dictionaryInfo);
        if (dictionaryInfo.getDictionaryDetailList() != null && !dictionaryInfo.getDictionaryDetailList().isEmpty()) {
            dictionaryDao.addDictionaryDetail(dictionaryInfo.getDictionaryDetailList());
        }
    }

    @Override
    @Transactional
    public void updateDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryDao.updateDictionaryInfo(dictionaryInfo);
        dictionaryDao.delDictionaryDetail(dictionaryInfo);
        if (dictionaryInfo.getDictionaryDetailList() != null && !dictionaryInfo.getDictionaryDetailList().isEmpty()) {
            dictionaryDao.addDictionaryDetail(dictionaryInfo.getDictionaryDetailList());
        }
    }

    @Override
    @Transactional
    public void delDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryDao.delDictionaryInfo(dictionaryInfo);
        dictionaryDao.delDictionaryDetail(dictionaryInfo);
    }
}
