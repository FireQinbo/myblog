package com.qb.myblog.controller;


import com.qb.myblog.entity.MbArticle;
import com.qb.myblog.service.IMbArticleService;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author qinbo
 * @since 2021-06-03
 */
//@CrossOrigin这个注解在controller类中使用。
//这样就可以指定该controller中所有方法都能处理来自http://localhost:8080中的请求。
//@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@RestController
@RequestMapping("/mb")
@Api(tags = "文章")
public class MbArticleController {
    @Autowired
    private IMbArticleService mbArticleService;

    @ApiOperation(value = "列表")
    @GetMapping("/getArticles")
    public ResultVo<?> getArticles() {
        List<MbArticle> mbArticleList = mbArticleService.list();
        return ResultVo.success("操作成功！", mbArticleList);
    }

    @ApiOperation(value = "根据id获取文章")
    @GetMapping("/getArticleById/{id}")
    public ResultVo<?> getArticleById(@PathVariable("id") String id) {
        MbArticle mbArticle = mbArticleService.getById(id);
        return ResultVo.success("操作成功！", mbArticle);
    }

}

