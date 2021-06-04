package com.qb.myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qb.myblog.entity.MbComment;
import com.qb.myblog.mapper.MbCommentMapper;
import com.qb.myblog.service.IMbCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
@Service
public class MbCommentServiceImpl extends ServiceImpl<MbCommentMapper, MbComment> implements IMbCommentService {

    @Autowired
    private MbCommentMapper mbCommentMapper;
    /**
     * 根据文章id获取评论列表
     *
     * @param articleId
     * @return
     */
    @Override
    public IPage<MbComment> getCommentsByArticleId(String articleId,Integer pageIndex) {
        QueryWrapper<MbComment> queryWrapper = new QueryWrapper<MbComment>();
        queryWrapper.eq("article_id", articleId);
        queryWrapper.orderByDesc("create_time");

        Page<MbComment> page = new Page<MbComment>(pageIndex,5);
        IPage<MbComment> mbCommentPage = mbCommentMapper.selectPage(page, queryWrapper);

        return mbCommentPage;
    }
}
