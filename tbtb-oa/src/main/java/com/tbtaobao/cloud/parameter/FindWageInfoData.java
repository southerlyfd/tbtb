package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ：jhb
 * @date ：2020-06-06 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindWageInfoData {

    private     Integer             wageId;
    private     Integer             employeeID; // '职工ID'
    private     BigDecimal          basePay;    // 基本工资
    private     BigDecimal          baseprize;  // 基本奖金
    private     BigDecimal          benifitprize;   // 效益奖金
    private     BigDecimal          insurance;  // 养老保险
    private     BigDecimal          medicare;   // 医疗保险
    private     BigDecimal          deprivepay; // 扣发工资
    private     BigDecimal          depriveprize;   // 扣发奖金
    private     BigDecimal          depriveattend;  // 考勤扣发
    private     String              name; // 职工姓名
}
