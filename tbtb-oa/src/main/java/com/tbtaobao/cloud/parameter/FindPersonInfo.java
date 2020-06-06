package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    // 职工ID
    private     Integer     employeeID;

    // 职工姓名
    private     String      name;

    private     String      sex;
    private     Long        date;
    private     Date        dates;
    private     String      city;
    private     String      nation;
    private     String      polity;
    private     String      culture;
    private     String      marriage;
    private     String      graduate;
    private     String      spec;
    private     String      speci;
    private     String      wtype;
    private     String      duty;
    private     String      depart;
    private     String      idcard;
    private     String      address;
    private     String      postcode;
    private     String      homePhone;
    private     String      mobile;
    private     String      email;
    private     String      resume;
    private     String      photo;

}
