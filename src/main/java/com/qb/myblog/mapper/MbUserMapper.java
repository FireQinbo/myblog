package com.qb.myblog.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qb.myblog.entity.MbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author qinb
 * @date 2021/4/2 15:37
 */
@Component
public interface MbUserMapper extends BaseMapper<MbUser> {

    List<MbUser> getAllMbUser();

    /**
     * 通过手机号获取用户
     *
     * @param mobile
     * @return
     */
    @Select("select t.* from mb_user t where t.mobile = #{mobile}")
    MbUser getMbUserByMobile(@Param("mobile") String mobile);
}
