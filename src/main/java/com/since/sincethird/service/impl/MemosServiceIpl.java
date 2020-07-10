package com.since.sincethird.service.impl;

import com.since.sincethird.entity.WXMemos;
import com.since.sincethird.repository.MemosRepository;
import com.since.sincethird.service.MemosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author jayzh
 */
@Service
public class MemosServiceIpl implements MemosService {
    @Autowired
    MemosRepository memosRepository;
    @Override
    public WXMemos save(WXMemos wXMemos) {


        return memosRepository.save(wXMemos);
    }

    @Override
    public List<WXMemos> findAllMemos() {
        return memosRepository.findAll();
    }
}
