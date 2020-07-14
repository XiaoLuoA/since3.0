package com.since.sincethird.service.impl;

import com.since.sincethird.common.Status;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.repository.UsersRep;
import com.since.sincethird.service.UserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersRep usersRep;

    @Override
    public WXUser findById(Long id) {
        return  usersRep.findById(id).get();
    }

    @Override
    public WXUser save(WxMpUser user) {
        WXUser wxUser = findByOpenId(user.getOpenId());
        if (null == wxUser){
            wxUser = new WXUser();
            wxUser.setOpenId(user.getOpenId());
            wxUser.setWxAddress(user.getProvince()+user.getCity());
            wxUser.setWxName(user.getNickname());
            wxUser.setStatus(Status.NORMAL);
            wxUser.setWxImage(user.getHeadImgUrl());
            return usersRep.save(wxUser);
        }
        return wxUser;
    }

    @Override
    public WXUser findByOpenId(String OpenId) {
        return usersRep.findByOpenId(OpenId);
    }


}
