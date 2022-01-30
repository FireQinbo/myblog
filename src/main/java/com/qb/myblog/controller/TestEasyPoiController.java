package com.qb.myblog.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.qb.myblog.dto.EasyPoiDto;
import com.qb.myblog.pojo.Member;
import com.qb.myblog.pojo.Order;
import com.qb.myblog.pojo.Product;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/easyPoi/test")
@Api(tags = "测试easyPoi")
public class TestEasyPoiController {
    @GetMapping("/exportExcel")
    @ApiOperation(value = "导出Excel", position = 1)
    public ResultVo<?> exportExcel(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        List<EasyPoiDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            EasyPoiDto easyPoiDto = new EasyPoiDto();
            easyPoiDto.setName("human_" + i);
            easyPoiDto.setAddress("chongqing_" + i);
            easyPoiDto.setMobile("1821038451" + i);
            if (i % 2 == 0) {
                easyPoiDto.setSex("male");
            } else {
                easyPoiDto.setSex("female");
            }
            easyPoiDto.setBirthday(LocalDate.now());
            easyPoiDto.setAge(i);
            list.add(easyPoiDto);
        }

        ExportParams params = new ExportParams("用户信息", "用户信息", ExcelType.XSSF);
        modelMap.put(NormalExcelConstants.DATA_LIST, list);
        modelMap.put(NormalExcelConstants.CLASS, EasyPoiDto.class);
        modelMap.put(NormalExcelConstants.PARAMS, params);
        modelMap.put(NormalExcelConstants.FILE_NAME, "memberList");
        PoiBaseView.render(modelMap, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
        return ResultVo.success("导出成功！", null);
    }

    @PostMapping("/importExcel")
    @ApiOperation(value = "导入Excel", position = 2)
    @SneakyThrows
    public ResultVo<?> importExcel(@RequestPart("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        params.setTitleRows(1);
        List<EasyPoiDto> objects = ExcelImportUtil.importExcel(file.getInputStream(), EasyPoiDto.class, params);
        return ResultVo.success("导入成功！", objects);
    }

    @ApiOperation(value = "导出订单信息", position = 3)
    @GetMapping("/exportOrderList")
    public ResultVo<?> exportOrderList(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        //构建会员数据
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Member member = new Member();
            member.setNickname("human_" + i);
            if (i % 2 == 0) {
                member.setGender(0);
            } else {
                member.setGender(1);
            }
            member.setIcon("icon_" + i);
            member.setId(i);
            member.setPassword("pwd_" + i);
            member.setPhone("1821038451" + i);
            member.setBirthday(LocalDate.now());
            member.setUsername("qinbo" + i);
            members.add(member);
        }
        //构建产品数据
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setId(i);
            product.setName("product_" + i);
            product.setBrandName("brandName_" + i);
            product.setProductSn("sn_" + i);
            product.setCount(i);
            product.setPrice(new BigDecimal(i));
            product.setSubTitle("subTitle_" + i);
            products.add(product);
        }
        //构建订单数据
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setId(i);
            order.setOrderSn("orderSn_" + i);
            order.setCreateTime(LocalDateTime.now());
            order.setReceiverAddress("address_" + i);
            order.setProductList(products);
            order.setMember(members.get(i));
            orderList.add(order);
        }
        ExportParams params = new ExportParams("订单信息", "订单信息", ExcelType.XSSF);
        //导出时排除一些字段
        params.setExclusions(new String[]{"ID"});
        modelMap.put(NormalExcelConstants.DATA_LIST, orderList);
        modelMap.put(NormalExcelConstants.CLASS, Order.class);
        modelMap.put(NormalExcelConstants.PARAMS, params);
        modelMap.put(NormalExcelConstants.FILE_NAME, "订单列表");
        PoiBaseView.render(modelMap, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);

        return ResultVo.success("导出成功！", null);
    }
}
