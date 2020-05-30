package com.tbtaobao.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ：jhb
 * @date ：2020-05-30 21:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wage {

    private     Integer             wageId;
    private     Integer             employeeID;
    private     BigDecimal          basePay;
    private     BigDecimal          baseprize;
    private     BigDecimal          benifitprize;
    private     BigDecimal          insurance;
    private     BigDecimal          medicare;
    private     BigDecimal          deprivepay;
    private     BigDecimal          depriveprize;
    private     BigDecimal          depriveattend;
}
