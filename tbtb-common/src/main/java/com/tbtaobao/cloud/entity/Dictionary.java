package com.tbtaobao.cloud.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 18:40
 * @description：字典类
 */
@Data
public class Dictionary {

    // 字典类型代码
    private String dictTypCd;
    // 字典值代码
    private String dictCd;
    // 字典值描述
    private String dictDesc;
    // 字典值来源
    private String dictSrc;
    // 字典类型代码集合
    private List<String> dictTypCdList;

}
