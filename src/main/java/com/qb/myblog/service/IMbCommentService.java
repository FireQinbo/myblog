package com.qb.myblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qb.myblog.entity.MbComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qb.myblog.vo.ResultVo;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
public interface IMbCommentService extends IService<MbComment> {

    /**
     * 根据文章id获取评论列表
     * @param articleId
     * @return
     */
    IPage<MbComment> getCommentsByArticleId(String articleId, Integer pageIndex);
}
