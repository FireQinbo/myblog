package com.qb.myblog.service;

import com.qb.myblog.entity.MbUser;
import com.qb.myblog.mapper.MbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author qinb
 * @date 2021/4/2 15:56
 */
public interface IMbUserService {
    List<MbUser> getAllMbUser();
}
