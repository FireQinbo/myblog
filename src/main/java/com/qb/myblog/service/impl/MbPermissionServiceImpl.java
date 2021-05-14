package com.qb.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qb.myblog.entity.MbPermission;
import com.qb.myblog.mapper.MbPermissionMapper;
import com.qb.myblog.service.IMbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Service
public class MbPermissionServiceImpl extends ServiceImpl<MbPermissionMapper, MbPermission> implements IMbPermissionService {

    @Autowired
    private MbPermissionMapper mbPermissionMapper;

    /**
     * 获取角色权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getRolePermissions(String userId) {
        return mbPermissionMapper.getRolePermissions(userId);
    }
}
