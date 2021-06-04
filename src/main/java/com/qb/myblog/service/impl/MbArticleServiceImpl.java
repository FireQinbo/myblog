package com.qb.myblog.service.impl;

import com.qb.myblog.entity.MbArticle;
import com.qb.myblog.mapper.MbArticleMapper;
import com.qb.myblog.service.IMbArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
@Service
public class MbArticleServiceImpl extends ServiceImpl<MbArticleMapper, MbArticle> implements IMbArticleService {

}
