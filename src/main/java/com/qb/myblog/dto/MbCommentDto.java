package com.qb.myblog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author qinbo
 * @since 2021-06-04
 */
@Data
@ApiModel(value="MbComment对象", description="评论表")
public class MbCommentDto implements Serializable {
    @ApiModelProperty(value = "被评论的文章id")
    @NotEmpty(message = "被评论的文章id不能为空！")
    private String articleId;

    @ApiModelProperty(value = "评论内容")
    @NotEmpty(message = "评论内容不能为空！")
    private String content;
}
