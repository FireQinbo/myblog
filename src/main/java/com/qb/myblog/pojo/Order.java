package com.qb.myblog.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author qinbo
 * @version 1.0.0 v
 * @date 2022-01-29 10:24
 * @description：订单
 * @modified By：
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order {
    @Excel(name = "ID", width = 10,needMerge = true)
    private Integer id;
    @Excel(name = "订单号", width = 20,needMerge = true)
    private String orderSn;
    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss",needMerge = true)
    private LocalDateTime createTime;
    @Excel(name = "收货地址", width = 20,needMerge = true )
    private String receiverAddress;
    @ExcelEntity(name = "会员信息")
    private Member member;
    @ExcelCollection(name = "商品列表")
    private List<Product> productList;
}
