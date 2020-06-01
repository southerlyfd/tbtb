package com.tbtaobao.cloud.service.impl;

import com.tbtaobao.cloud.dao.DictonaryDao;
import com.tbtaobao.cloud.entity.Dictionary;
import com.tbtaobao.cloud.service.DictionaryService;
import org.springframework.stereotype.Service;

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
    private DictonaryDao dictonaryDao;

    @Override
    public List<Dictionary> queryDictionary(Dictionary dictionary) {
        return dictonaryDao.queryDictionary(dictionary);
    }

    @Override
    public void addDictionary(List<Dictionary> dictionaryList) {
        dictonaryDao.addDictionary(dictionaryList);
    }

    @Override
    public void delDictionary(Dictionary dictionary) {
        dictonaryDao.delDictionary(dictionary);
    }
}
