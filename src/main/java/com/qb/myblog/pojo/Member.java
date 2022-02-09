package com.qb.myblog.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA
 *
 * @author qinbo
 * @version 1.0.0 v
 * @date 2022-01-29 10:16
 * @description：购物会员
 * @modified By：
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Member {
    @Excel(name = "ID", width = 10)
    private Integer id;
    @Excel(name = "用户名", width = 20, needMerge = true)
    private String username;
    private String password;
    @Excel(name = "昵称", width = 20, needMerge = true)
    private String nickname;
    @Excel(name = "出生日期", width = 20, needMerge = true, format = "yyyy-MM-dd")
    private LocalDate birthday;
    @Excel(name = "手机号", width = 20, needMerge = true, desensitizationRule = "3_4")
    private String phone;
    private String icon;
    @Excel(name = "性别", width = 10, needMerge = true, replace = {"男_0", "女_1"})
    private Integer gender;
}
