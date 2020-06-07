package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jhb
 * @date ：2020-06-07 14:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAttendInfoData {

    private Integer attendId;
    private Integer employeeID; // 职工ID
    private Integer late;   // 迟到
    private Integer leaceearly; // 早退
    private Integer jobwound; // 公休假
    private Integer sleave; // 病假
    private Integer paLeave; // 事假
    private String  name; // 职工姓名
}
