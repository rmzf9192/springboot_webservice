package com.el.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 16:09
 * @Version:V1.0
 * @Description:UserModel
 */
@Data
@ToString
@AllArgsConstructor
public class UserModel implements Serializable {
    private String name;
    private boolean sex; //false：男,true：女
    private Integer age;
}
