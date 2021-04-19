package com.qb.myblog.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qb.myblog.entity.MbUser;
import org.springframework.stereotype.Component;

/**
 * @author qinb
 * @date 2021/4/2 15:37
 */
@Component
public interface MbUserMapper extends BaseMapper<MbUser> {

    List<MbUser> getAllMbUser();

}
