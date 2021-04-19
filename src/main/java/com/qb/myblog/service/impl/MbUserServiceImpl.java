package com.qb.myblog.service.impl;

import com.qb.myblog.entity.MbUser;
import com.qb.myblog.mapper.MbUserMapper;
import com.qb.myblog.service.IMbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinb
 * @date 2021/4/2 15:57
 */
@Service
public class MbUserServiceImpl implements IMbUserService {
    @Autowired
    private MbUserMapper mbUserMapper;

    @Override
    public List<MbUser> getAllMbUser() {
        return mbUserMapper.getAllMbUser();
    }
}
