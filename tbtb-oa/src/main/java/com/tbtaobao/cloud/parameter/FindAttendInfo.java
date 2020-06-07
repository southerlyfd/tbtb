package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jhb
 * @date ：2020-06-07 12:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAttendInfo {

    // 当前页
    private Integer currentPage;

    // 每页显示记录数
    private Integer onePageCount;

    // 主键
    private Integer attendId;
    private Integer employeeID; // 职工ID
    private Integer late;   // 迟到
    private Integer leaceearly; // 早退
    private Integer jobwound; // 公休假
    private Integer sleave; // 病假
    private Integer paLeave; // 事假
    private String  name; // 职员姓名

   /* `attend_id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_id` int(10) NOT NULL COMMENT '职工ID',
            `late` int(10) DEFAULT NULL COMMENT '迟到',
            `leaceearly` int(10) DEFAULT NULL COMMENT '早退',
            `jobwound` bigint(10) DEFAULT NULL COMMENT '公休假',
            `s_leave` bigint(10) DEFAULT NULL COMMENT '病假',
            `pa_leave` int(10) DEFAULT NULL COMMENT '事假',*/
}
