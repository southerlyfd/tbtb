package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jhb
 * @date ：2020-06-06 21:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMageInfo {

    // 当前页
    private Integer currentPage;

    // 每页显示记录数
    private Integer onePageCount;

    // 职工ID
    private     Integer     employeeID;

    // 职工姓名
    private     String      name;
}
