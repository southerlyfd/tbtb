package com.tbtaobao.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jhb
 * @date ：2020-04-12 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;
    private Integer employeeID;
    private String name;
}
