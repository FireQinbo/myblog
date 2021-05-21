package com.qb.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.entity.MbUserRole;
import com.qb.myblog.mapper.MbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author qinb
 * @date 2021/4/2 15:56
 */
public interface IMbUserService extends IService<MbUser> {
    List<MbUser> getAllMbUser();

    /**
     * 注册用户
     * @param mbUser
     * @throws Exception
     */
    void register(MbUser mbUser) throws Exception;
}
