package com.qb.myblog.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * name：Excel中的列名；
 * width：指定列的宽度；
 * needMerge：是否需要纵向合并单元格；
 * format：当属性为时间类型时，设置时间的导出导出格式；
 * desensitizationRule：数据脱敏处理，3_4表示只显示字符串的前3位和后4位，其他为*号；
 * replace：对属性进行替换；
 * suffix：对数据添加后缀。
 */

@Data
public class EasyPoiDto {
    @Excel(name = "姓名", width = 20, needMerge = true)
    @ApiModelProperty(value = "姓名", position = 1)
    private String name;

    @Excel(name = "性别", replace = {"男_male", "女_female"}, width = 10, needMerge = true)
    @ApiModelProperty(value = "性别(male:男,female:女)", position = 2)
    private String sex;

    @Excel(name = "地址", width = 20, needMerge = true)
    @ApiModelProperty(value = "地址", position = 3)
    private String address;

    @Excel(name = "出生日期", width = 20, needMerge = true, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期", position = 4)
    private LocalDate birthday;

    @Excel(name = "年龄", width = 20, needMerge = true)
    @ApiModelProperty(value = "年龄", position = 5)
    private Integer age;

    @Excel(name = "手机号", width = 20, needMerge = true, desensitizationRule = "3_4")
    @ApiModelProperty(value = "手机号", position = 6)
    private String mobile;
}
