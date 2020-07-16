package com.since.sincethird.repository;

import com.since.sincethird.entity.WXMemos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jayzh
 */
@Repository
public interface MemosRepository extends JpaRepository<WXMemos,Integer> {
    /**this interface aim to delete the massage by id
     * @param id
     */
    @Override
    public void deleteById(Integer id);
}
