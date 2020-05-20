package com.tbtaobao.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：jhb
 * @date ：2020-04-12 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private     Integer     employeeID;
    private     String      name;
    private     String      sex;
    private     Date        date;
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


    /*
    * Sex` varchar(50) DEFAULT NULL COMMENT '性别',
  `Date` varchar(50) DEFAULT NULL COMMENT '出生年月',
  `City` varchar(45) DEFAULT NULL COMMENT '籍贯',
  `Nation` varchar(45) DEFAULT NULL COMMENT '民族',
  `Polity` varchar(45) DEFAULT NULL COMMENT '政治面貌',
  `Culture` varchar(45) DEFAULT NULL COMMENT '文化程度',
  `Marriage` varchar(45) DEFAULT NULL COMMENT '结婚状况',
  `Graduate` varchar(45) DEFAULT NULL COMMENT '毕业院校',
  `Spec` varchar(45) DEFAULT NULL COMMENT '所学专业',
  `Speci` varchar(45) DEFAULT NULL COMMENT '个人专长',
  `Wtype` varchar(45) DEFAULT NULL COMMENT '工种',
  `Duty` varchar(45) DEFAULT NULL COMMENT '职务',
  `Depart` varchar(45) DEFAULT NULL COMMENT '部门名称',
  `IDcard` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `Address` varchar(45) DEFAULT NULL COMMENT '家庭住址',
  `Postcode` varchar(45) DEFAULT NULL COMMENT '邮编',
  `HomePhone` varchar(45) DEFAULT NULL COMMENT '家庭电话',
  `Mobile` varchar(45) DEFAULT NULL COMMENT '手机',
  `Email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `Resume` varchar(45) DEFAULT NULL COMMENT '个人简历',
  `Photo` varchar(45) DEFAULT NULL COMMENT '照片',
    * */
}
