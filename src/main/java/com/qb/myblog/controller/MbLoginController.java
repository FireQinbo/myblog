package com.qb.myblog.controller;

import com.qb.myblog.constant.CommonConstant;
import com.qb.myblog.dto.MbUserDto;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.JWTUtil;
import com.qb.myblog.utils.RedisUtil;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author qinb
 * @date 2021/5/20 10:54
 */
@RestController
@Api(tags = "登录接口")
@Slf4j
@RequestMapping("/mb")
@Validated
public class MbLoginController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IMbUserService mbUserService;

    @ApiOperation("登录")
    @GetMapping("/login")
    public ResultVo<Object> login(@Valid @RequestBody MbUserDto mbUserDto) {
        ResultVo<Object> resultVo = new ResultVo<>();
        MbUser mbUser = mbUserService.getMbUserByMobile(mbUserDto.getMobile());
        if (mbUser == null) {
            resultVo.failure("用户不存在！", null);
            return resultVo;
        }
        //设置hash算法迭代次数
        int times = 2;
        String checkPwd = new SimpleHash("md5", mbUserDto.getPassword(), mbUser.getSalt(), times).toString();
        if (!checkPwd.equals(mbUser.getPassword())) {
            resultVo.failure("密码错误！", null);
            return resultVo;
        }

        //获取token
        String token = JWTUtil.sign(mbUserDto.getMobile(), mbUser.getPassword());
        //缓存token 一小时后失效
        redisUtil.set(CommonConstant.PREFIX_TOKEN + token, token, 3600);

        resultVo.success("登录成功！", token);
        return resultVo;
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultVo<Object> register(@Valid @RequestBody MbUserDto mbUserDto) {
        ResultVo<Object> resultVo = new ResultVo<>();
        MbUser mbUserDb = mbUserService.getMbUserByMobile(mbUserDto.getMobile());
        if (mbUserDb != null) {
            resultVo.failure("该手机号已注册！", null);
            return resultVo;
        }

        //利用shiro自带的SecureRandomNumberGenerator 生成盐值，默认16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置hash算法迭代次数
        int times = 2;
        //获取hash后的密码
        String encodedPwd = new SimpleHash("md5", mbUserDto.getPassword(), salt, times).toString();

        MbUser mbUser = new MbUser();
        mbUser.setUserName(mbUserDto.getUserName());
        mbUser.setMobile(mbUserDto.getMobile());
        mbUser.setPassword(encodedPwd);
        mbUser.setSalt(salt);

        try {
            mbUserService.register(mbUser);
            resultVo.success("注册成功，请登录！", null);
        } catch (Exception e) {
            resultVo.failure("注册失败！", e.getMessage());
        }

        return resultVo;
    }


    /**
     * 测试角色权限接口
     * @return
     */
    @RequiresRoles(value = {"admin"})
    @GetMapping("/testRole")
    public ResultVo<Object> testRole() {
        ResultVo<Object> resultVo = new ResultVo<>();

        resultVo.success("进入成功！", null);

        return resultVo;
    }

    /**
     * 测试菜单权限接口
     * 说明：logical = Logical.OR （登录角色包含admin:add，admin:select，admin:viwe其中一个就可以通过认证）
     * @return
     */
    @RequiresPermissions(value = {"admin:add","admin:select","admin:viwe"},logical = Logical.OR)
    @GetMapping("/testPermission")
    public ResultVo<Object> testPermission() {
        ResultVo<Object> resultVo = new ResultVo<>();

        resultVo.success("进入成功！", null);

        return resultVo;
    }
}
