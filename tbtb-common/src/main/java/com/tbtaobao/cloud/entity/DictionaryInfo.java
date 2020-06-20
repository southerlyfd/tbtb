package com.tbtaobao.cloud.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-06-20 16:18
 * @description：
 */
@Data
public class DictionaryInfo {

    // 字典类型代码
    private String dictTypCd;
    // 字典类型描述
    private String dictTypDesc;
    // 字典来源
    private String dtSrc;
    // 字典类型代码集合
    private List<String> dictTypCdList;
    // 字典值集合
    private List<DictionaryDetail> dictionaryDetailList;
}
