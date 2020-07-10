package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 王英豪111
 */
@Service
public class ListServiceImpl implements ListService {


    @Autowired
    private ListRepository listRepository;

    @Override
    public WXList save(WXList wxList) {
        return listRepository.save(wxList);
    }


    @Override
    public List<WXList> findListByOpenId(String open_id) {
        return listRepository.findAllByOpen_id(open_id);
    }



}
