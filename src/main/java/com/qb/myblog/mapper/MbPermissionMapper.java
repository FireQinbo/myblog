package com.qb.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qb.myblog.entity.MbPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Component
public interface MbPermissionMapper extends BaseMapper<MbPermission> {

    /**
     * 获取角色权限
     *
     * @return
     */
    List<String> getRolePermissions(@Param("userId") String userId);

}
