package com.since.sincethird.service;

import com.since.sincethird.entity.WXMemos;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author jayzh
 */
public interface MemosService {
    /**save the a message
     * @param wxMemos
     * @return this message
     */
    public WXMemos save(WXMemos wxMemos );

    /**find all messages
     * @return list of message
     */
    public List<WXMemos> findAllMemos();

    /** delete a message by id
     * @param id
     */
    public void deleteById(Integer id);
}
