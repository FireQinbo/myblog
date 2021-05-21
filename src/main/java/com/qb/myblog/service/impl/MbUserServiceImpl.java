package com.qb.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qb.myblog.entity.MbPermission;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.mapper.MbPermissionMapper;
import com.qb.myblog.mapper.MbUserMapper;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.vo.LoginUser;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinb
 * @date 2021/4/2 15:57
 */
@Service
public class MbUserServiceImpl extends ServiceImpl<MbUserMapper, MbUser> implements IMbUserService {
    @Autowired
    private MbUserMapper mbUserMapper;

    @Override
    public List<MbUser> getAllMbUser() {
        return mbUserMapper.getAllMbUser();
    }

    /**
     * 注册用户
     *
     * @param mbUser
     * @throws Exception
     */
    @Override
    public void register(MbUser mbUser) throws Exception {
        mbUserMapper.insert(mbUser);
    }

    /**
     * 通过手机号获取用户
     *
     * @param mobile
     * @return
     */
    @Override
    public MbUser getMbUserByMobile(String mobile) {
        return mbUserMapper.getMbUserByMobile(mobile);
    }

    /**
     * 创建登录用户，来自系统用户的部分信息
     *
     * @param loginName
     * @return
     */
    @Override
    public LoginUser createLoginUser(String loginName) {
        LoginUser loginUser = new LoginUser();
        MbUser mbUser = this.getMbUserByMobile(loginName);
        loginUser.setId(mbUser.getId());
        loginUser.setUserName(mbUser.getUserName());
        loginUser.setMobile(mbUser.getMobile());
        loginUser.setPassword(mbUser.getPassword());
        return loginUser;
    }
}
