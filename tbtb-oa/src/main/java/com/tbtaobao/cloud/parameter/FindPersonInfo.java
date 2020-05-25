package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jhb
 * @date ：2020-05-25 22:10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPersonInfo {

    // 当前页
    private Integer currentPage;

    // 每页显示记录数
    private Integer onePageCount;
}
