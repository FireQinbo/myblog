package com.qb.myblog.controller;


import com.qb.myblog.entity.MbArticle;
import com.qb.myblog.service.IMbArticleService;
import com.qb.myblog.vo.ResultVo;
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
public class MbArticleController {
    @Autowired
    private IMbArticleService mbArticleService;

    @GetMapping("/getArticles")
    public ResultVo<List<MbArticle>> getArticles() {
        ResultVo<List<MbArticle>> resultVo = new ResultVo<>();
        List<MbArticle> mbArticleList = mbArticleService.list();
        resultVo.success("操作成功！", mbArticleList);
        return resultVo;
    }

    @GetMapping("/getArticleById/{id}")
    public ResultVo<MbArticle> getArticleById(@PathVariable("id") String id) {
        ResultVo<MbArticle> resultVo = new ResultVo<>();
        MbArticle mbArticle = mbArticleService.getById(id);
        resultVo.success("操作成功！", mbArticle);

        return resultVo;
    }

}

