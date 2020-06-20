package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entity.DictionaryInfo;
import com.tbtaobao.cloud.result.ServiceResult;
import com.tbtaobao.cloud.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 19:58
 * @description：
 */
@RestController
@Slf4j
@RequestMapping(value = "/dictionary")
public class DictionaryController {

    @Resource
    private DictionaryService dictionaryService;

    /**
     * 查询字典
     * @param dictionaryInfo
     * @return
     */
    @RequestMapping("/queryDictionary")
    public ServiceResult queryDictionary(DictionaryInfo dictionaryInfo) {
        List<DictionaryInfo> dictionaryList = dictionaryService.queryDictionary(dictionaryInfo);
        return new ServiceResult(dictionaryList);
    }

    /**
     * 新增字典
     * @param dictionaryInfo
     * @return
     */
    @RequestMapping("/addDictionary")
    public ServiceResult addDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryService.addDictionary(dictionaryInfo);
        return new ServiceResult();
    }

    /**
     * 修改字典
     * @param dictionaryInfo
     * @return
     */
    @RequestMapping("/updateDictionary")
    public ServiceResult updateDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryService.addDictionary(dictionaryInfo);
        return new ServiceResult();
    }

    /**
     * 删除字典
     * @param dictionaryInfo
     * @return
     */
    @RequestMapping("/delDictionary ")
    public ServiceResult delDictionary(DictionaryInfo dictionaryInfo) {
        dictionaryService.delDictionary(dictionaryInfo);
        return new ServiceResult();
    }
}
