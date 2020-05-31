package com.tbtaobao.cloud.controller;

import com.tbtaobao.cloud.entity.Dictionary;
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
     * @param dictionary
     * @return
     */
    @RequestMapping("/queryDictionary")
    public ServiceResult queryDictionary(Dictionary dictionary) {
        List<Dictionary> dictionaryList = dictionaryService.queryDictionary(dictionary);
        return new ServiceResult(dictionaryList);
    }

    /**
     * 新增字典值
     * @param dictionaryList
     * @return
     */
    @RequestMapping("/addDictionary")
    public ServiceResult addDictionary(List<Dictionary> dictionaryList) {
        dictionaryService.addDictionary(dictionaryList);
        return new ServiceResult();
    }

    /**
     * 删除字典值
     * @param dictionary
     * @return
     */
    @RequestMapping("/delDictionary ")
    public ServiceResult delDictionary(Dictionary dictionary) {
        dictionaryService.delDictionary(dictionary);
        return new ServiceResult();
    }
}
