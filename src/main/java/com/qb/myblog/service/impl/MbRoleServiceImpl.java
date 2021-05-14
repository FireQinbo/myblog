package com.qb.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qb.myblog.entity.MbRole;
import com.qb.myblog.mapper.MbRoleMapper;
import com.qb.myblog.service.IMbRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Service
public class MbRoleServiceImpl extends ServiceImpl<MbRoleMapper, MbRole> implements IMbRoleService {
    @Autowired
    private MbRoleMapper mbRoleMapper;

    /**
     * 获取用户所拥有角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserRoles(String userId) {
        return mbRoleMapper.getUserRoles(userId);
    }
}
