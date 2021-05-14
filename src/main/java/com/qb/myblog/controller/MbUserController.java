package com.qb.myblog.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.RedisUtil;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinb
 * @date 2021/4/2 16:01
 */
@Api("用户管理API")
@RestController
@RequestMapping(value = "/mb")
@Validated
public class MbUserController {
    @Autowired
    private IMbUserService mbUserService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("获取所有用户到Redis中")
    @GetMapping(value = "/getAllMbUser")
    public ResultVo<JSONObject> getAllMbUser() {
        ResultVo<JSONObject> resultVo = new ResultVo<>();
        try{
            redisUtil.set("users", mbUserService.getAllMbUser(),60);
            resultVo.success("操作成功！", null);
        }catch (Exception e){
            resultVo.success("操作失败！", null);
            e.printStackTrace();
        }
        return resultVo;
    }

    @ApiOperation("从Redis中获取用户")
    @GetMapping(value = "/getMbUsersFromRedis")
    public ResultVo<Object> getMbUsersFromRedis() {
        ResultVo<Object> resultVo = new ResultVo<>();
        try{
            resultVo.success("操作成功！", (List<MbUser>) redisUtil.get("users"));
        }catch (Exception e){
            resultVo.success("操作失败！", null);
            e.printStackTrace();
        }
        return resultVo;
    }

    @ApiOperation("获取微信用户openid")
    @GetMapping(value = "/getOpenId")
    public ResultVo<JSONObject> getOpenId(@RequestParam("code") String code) {
        ResultVo<JSONObject> resultVo = new ResultVo<>();
        String appid = "wxd4a9edd31c3f3f78";
        String secret = "34bb20f2938e1cf627143ea9909d0a17";

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String resultBody = HttpRequest.get(url).execute().body();
        JSONObject jsonObject = JSONObject.parseObject(resultBody);
        resultVo.setResult(jsonObject);

        System.out.println("resultBody = " + resultBody);
        return resultVo;
    }

    @GetMapping("/testValid")
    public ResultVo<T> testValid(@Valid @RequestParam("name") @NotEmpty(message = "name不能为空") String name) {
        ResultVo resultVo = new ResultVo();

        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        resultVo.success("操作成功！", map);


        return resultVo;
    }
}
