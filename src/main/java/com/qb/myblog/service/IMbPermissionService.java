package com.qb.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qb.myblog.entity.MbPermission;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
public interface IMbPermissionService extends IService<MbPermission> {
    /**
     * 获取角色权限
     *
     * @return
     */
    List<String> getRolePermissions(String userId);
}
