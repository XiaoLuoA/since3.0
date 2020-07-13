package com.since.sincethird.repository;

import com.since.sincethird.entity.WXMemos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jayzh
 */
@Repository
public interface MemosRepository extends JpaRepository<WXMemos,Integer> {
    @Override
    public void deleteById(Integer id);
}
