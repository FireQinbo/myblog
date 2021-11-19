package com.qb.myblog.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qb.myblog.dto.MbCommentDto;
import com.qb.myblog.entity.MbComment;
import com.qb.myblog.service.IMbCommentService;
import com.qb.myblog.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/mb")
@Validated
@Api(tags = "评论")
public class MbCommentController {
    @Autowired
    private IMbCommentService mbCommentService;

    @ApiOperation(value = "根据文章id获取评论")
    @GetMapping("/getCommentsByArticleId/{articleId}")
    public ResultVo<JSONObject> getCommentsByArticleId(@PathVariable("articleId") String articleId, @RequestParam("pageIndex") Integer pageIndex) {
        ResultVo<JSONObject> resultVo = new ResultVo<>();
        JSONObject jsonObj = new JSONObject();
        IPage<MbComment> mbCommentPage = mbCommentService.getCommentsByArticleId(articleId,pageIndex);
        jsonObj.put("total", mbCommentPage.getTotal());
        jsonObj.put("data", mbCommentPage.getRecords());
        resultVo.setResult(jsonObj);
        return resultVo;
    }

    @ApiOperation(value = "添加评论")
    @PostMapping("/addComment")
    public ResultVo<?> addComment(@Valid @RequestBody MbCommentDto mbCommentDto) {
        mbCommentService.addComment(mbCommentDto);
        return ResultVo.success("添加成功！", null);
    }
}

