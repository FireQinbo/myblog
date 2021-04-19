package com.qb.myblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qinb
 * @date 2021/4/2 15:43
 */
@Data
public class MbUser implements Serializable {
    private String id;
    private String userName;
    private String password;
    private String mobile;
    private String salt;
}
