package com.since.sincethird.service.impl;

import com.since.sincethird.entity.WXUser;
import com.since.sincethird.repository.UsersRep;
import com.since.sincethird.service.UserService;
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
    public WXUser save(WXUser WXUser) {
        return usersRep.save(WXUser);
    }


}
