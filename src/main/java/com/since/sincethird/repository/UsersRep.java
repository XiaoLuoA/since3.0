package com.since.sincethird.repository;

import com.since.sincethird.entity.WXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRep extends JpaRepository<WXUser,Long> {

}

