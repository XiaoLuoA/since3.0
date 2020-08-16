package com.since.sincethird.repository;

import com.since.sincethird.entity.Ruser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayzh
 */
public interface ReportRepository extends JpaRepository<Ruser,Long> {
    /**
     * @param openid
     * @return
     */
    Ruser findRuserByOpenid(String openid);
}
