package com.qb.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qb.myblog.entity.MbRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Component
public interface MbRoleMapper extends BaseMapper<MbRole> {

    /**
     * 获取用户所拥有角色
     * @param userId
     * @return
     */
    List<String> getUserRoles(@Param("userId") String userId);
}
