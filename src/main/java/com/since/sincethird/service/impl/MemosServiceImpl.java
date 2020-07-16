package com.since.sincethird.service.impl;

import com.since.sincethird.entity.WXMemos;
import com.since.sincethird.repository.MemosRepository;
import com.since.sincethird.service.MemosService;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @author jayzh
 */
@Service
public class MemosServiceImpl implements MemosService {
    @Autowired
    MemosRepository memosRepository;
    @Override
    public WXMemos save(WXMemos wxMemos) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        wxMemos.setMessageTime(formatter.format(date).toString());
        String messageFilter = Jsoup.clean(wxMemos.getMessage(),Whitelist.none());
        wxMemos.setMessage(messageFilter);
        return memosRepository.save(wxMemos);
    }

    @Override
    public List<WXMemos> findAllMemos() {
        return memosRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        memosRepository.deleteById(id);
    }
}
