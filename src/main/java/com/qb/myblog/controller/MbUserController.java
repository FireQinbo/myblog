package com.qb.myblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.RedisUtil;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qinb
 * @date 2021/4/2 16:01
 */
@Api("用户管理API")
@RestController
@RequestMapping(value = "/mb")
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
}
