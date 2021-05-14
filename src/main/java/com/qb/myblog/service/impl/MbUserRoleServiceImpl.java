package com.qb.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qb.myblog.entity.MbUserRole;
import com.qb.myblog.mapper.MbUserRoleMapper;
import com.qb.myblog.service.IMbUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色表 服务实现类
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Service
public class MbUserRoleServiceImpl extends ServiceImpl<MbUserRoleMapper, MbUserRole> implements IMbUserRoleService {

}
