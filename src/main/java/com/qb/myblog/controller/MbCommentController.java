package com.qb.myblog.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qb.myblog.dto.MbCommentDto;
import com.qb.myblog.entity.MbComment;
import com.qb.myblog.service.IMbCommentService;
import com.qb.myblog.vo.ResultVo;
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
public class MbCommentController {
    @Autowired
    private IMbCommentService mbCommentService;

    @GetMapping("/getCommentsByArticleId/{articleId}")
    public ResultVo<JSONObject> getCommentsByArticleId(@PathVariable("articleId") String articleId, @RequestParam("pageIndex") Integer pageIndex) {
        ResultVo<JSONObject> resultVo = new ResultVo<>();
        JSONObject jsonObj = new JSONObject();
        IPage<MbComment> mbCommentPage = mbCommentService.getCommentsByArticleId(articleId,pageIndex);
        jsonObj.put("total", mbCommentPage.getTotal());
        jsonObj.put("data", mbCommentPage.getRecords());
        resultVo.success("操作成功！", jsonObj);
        return resultVo;
    }

    @PostMapping("/addComment")
    public ResultVo<Object> addComment(@Valid @RequestBody MbCommentDto mbCommentDto) {
        ResultVo<Object> resultVo = new ResultVo<>();
        mbCommentService.addComment(mbCommentDto);
        resultVo.success("添加成功！", null);
        return resultVo;
    }
}

