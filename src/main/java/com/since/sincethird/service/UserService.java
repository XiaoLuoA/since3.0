package com.since.sincethird.service;

import com.since.sincethird.entity.WXUser;


public interface UserService {
    /**
     * 通过id获取一个人
     * @param id 人的主键
     * @return User
     */
    WXUser findById(Long id);

    WXUser save(WXUser WXUser);

    WXUser findByOpenId(String OpenId);





}
