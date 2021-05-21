package com.qb.myblog.controller;

import com.qb.myblog.constant.CommonConstant;
import com.qb.myblog.dto.MbUserDto;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.RedisUtil;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
        //获取登录subject
        Subject subject = SecurityUtils.getSubject();
        //根据用户名 密码创建token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(mbUserDto.getUserName(), mbUserDto.getPassword());
        try {
            subject.login(usernamePasswordToken);
            //redis存储token 一小时失效
            redisUtil.set(CommonConstant.PREFIX_TOKEN + usernamePasswordToken, usernamePasswordToken, 3600);
            resultVo.success("登录成功！", null);
        } catch (UnknownAccountException e) {
            resultVo.failure("用户不存在！", null);
        } catch (IncorrectCredentialsException e) {
            resultVo.failure("密码错误！", null);
        }

        return resultVo;
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultVo<Object> register(@Valid @RequestBody MbUserDto mbUserDto) {
        ResultVo<Object> resultVo = new ResultVo<>();

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
}
