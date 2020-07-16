package com.since.sincethird.service;

import com.since.sincethird.entity.WXUser;
import me.chanjar.weixin.mp.bean.result.WxMpUser;


public interface UserService {
    /**
     * 通过id获取一个人
     * @param id 人的主键
     * @return User
     */
    WXUser findById(Long id);

    /**
     * 保存一个User
     * @param wxUser
     * @return WXUser
     */

    WXUser save(WxMpUser wxUser);

    /**
     * 通过openId 查询一个WXUser
     * @param openId 人的主键
     * @return WXUser
     */

    WXUser findByOpenId(String openId);





}
