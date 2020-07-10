package com.since.sincethird.service;

import com.since.sincethird.entity.WXMemos;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author jayzh
 */
public interface MemosService {
    public WXMemos save(WXMemos wXMemos );
    public List<WXMemos> findAllMemos();
}
