package com.tbtaobao.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：jhb
 * @date ：2020-05-20 20:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Integer userId;

    private String accountNum;

    private String password;

    private String accessToken;

    private Date createTime;

    private Date updateTime;
}
