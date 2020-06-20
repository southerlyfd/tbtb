package com.tbtaobao.cloud.service;

import com.tbtaobao.cloud.entity.DictionaryInfo;

import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 19:46
 * @description：
 */
public interface DictionaryService {

    /**
     * 查询字典
     */
    List<DictionaryInfo> queryDictionary(DictionaryInfo dictionaryInfo);

    /**
     * 新增字典
     */
    void addDictionary(DictionaryInfo dictionaryInfo);

    /**
     * 修改字典
     */
    void updateDictionary(DictionaryInfo dictionaryInfo);

    /**
     * 删除字典
     */
    void delDictionary(DictionaryInfo dictionaryInfo);
}
