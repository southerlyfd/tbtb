package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.entity.DictionaryDetail;
import com.tbtaobao.cloud.entity.DictionaryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 19:45
 * @description：
 */
@Mapper
public interface DictionaryDao {

    /**
     * 查询字典类型
     */
    List<DictionaryInfo> queryDictionaryInfo(DictionaryInfo dictionaryInfo);

    /**
     * 新增字典类型
     */
    void addDictionaryInfo(DictionaryInfo dictionaryInfo);

    /**
     * 修改字典类型
     */
    void updateDictionaryInfo(DictionaryInfo dictionaryInfo);

    /**
     * 删除字典类型
     */
    void delDictionaryInfo(DictionaryInfo dictionaryInfo);

    /**
     * 查询字典值
     */
    List<DictionaryDetail> queryDictionaryDetail(DictionaryInfo dictionaryInfo);

    /**
     * 新增字典值
     */
    void addDictionaryDetail(List<DictionaryDetail> dictionaryList);

    /**
     * 删除字典值
     */
    void delDictionaryDetail(DictionaryInfo dictionaryInfo);
}
