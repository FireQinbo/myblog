package com.qb.myblog.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "测试Sa-Token")
@ApiSort(value = 1)
@RequestMapping("/saToken/test")
public class TestSaTokenController {
    @ApiOperation(value = "测试Sa-Token登陆", position = 1)
    @PostMapping("/doLogin")
    public ResultVo<?> doLogin(@ApiParam(name = "userName", value = "用户姓名") @RequestParam(name = "userName") String userName,
                               @ApiParam(name = "password", value = "密码") @RequestParam(name = "password") String password) {
        if ("human".equals(userName) && "123456".equals(password)) {
            StpUtil.login("1001");
            return ResultVo.success("登陆成功！", null);
        }
        return ResultVo.failure("登陆失败！", null);
    }

    @GetMapping("/isLogin")
    @ApiOperation(value = "测试是否登陆", position = 2)
    public ResultVo<?> isLogin() {
        Object loginId = StpUtil.getLoginId();
        boolean isLogin = StpUtil.isLogin();
        return ResultVo.success("操作成功！", loginId.toString());
    }
}
