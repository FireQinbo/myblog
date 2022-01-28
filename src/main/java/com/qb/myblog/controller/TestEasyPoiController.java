package com.qb.myblog.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.qb.myblog.dto.EasyPoiDto;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
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
}
