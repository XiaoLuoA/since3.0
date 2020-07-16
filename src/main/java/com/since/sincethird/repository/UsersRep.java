package com.since.sincethird.repository;

import com.since.sincethird.entity.WXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRep extends JpaRepository<WXUser,Long> {

    /**
     * 通过openId 查询一个WXUser
     * @param openId 人的主键
     * @return WXUser
     */

    WXUser findByOpenId(String openId);



}

