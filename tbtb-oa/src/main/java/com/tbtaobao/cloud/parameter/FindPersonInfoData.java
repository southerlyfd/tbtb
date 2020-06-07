package com.tbtaobao.cloud.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：jhb
 * @date ：2020-06-07 16:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPersonInfoData {

    private     Integer     employeeID;
    private     String      name;
    private     String      sex;
    private     Long         date;
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
