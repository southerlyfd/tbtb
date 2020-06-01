package com.tbtaobao.cloud.dao;

import com.tbtaobao.cloud.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 19:45
 * @description：
 */
@Mapper
public interface DictonaryDao {

    /**
     * 查询字典类型
     */
    List<Dictionary> queryDictionary(Dictionary dictionary);

    /**
     * 新增字典值
     */
    void addDictionary(List<Dictionary> dictionaryList);

    /**
     * 删除字典值
     */
    void delDictionary(Dictionary dictionary);
}
