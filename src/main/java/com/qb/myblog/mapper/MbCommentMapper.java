package com.qb.myblog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qb.myblog.entity.MbComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
public interface MbCommentMapper extends BaseMapper<MbComment> {
    /**
     * 根据文章id获取评论列表
     *
     * @param articleId
     * @return
     */
    @Select("select t.* from mb_comment t where t.article_id = #{articleId} order by create_time desc")
    List<MbComment> getCommentsByArticleId(Page<MbComment> page, @Param("articleId") String articleId);
}
