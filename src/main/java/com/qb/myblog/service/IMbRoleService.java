package com.qb.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qb.myblog.entity.MbRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
public interface IMbRoleService extends IService<MbRole> {

    /**
     * 获取用户所拥有角色
     * @param userId
     * @return
     */
    List<String> getUserRoles(String userId);
}
