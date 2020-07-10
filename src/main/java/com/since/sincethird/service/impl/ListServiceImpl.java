package com.since.sincethird.service.impl;

import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 王英豪111
 */
public class ListServiceImpl implements ListService {


    @Autowired
    private ListRepository listRepository;

    @Override
    public void add(WXList wxList) {
        listRepository.addList(wxList);
    }


    @Override
    public WXList findListByOpenId(String open_id) {
        return listRepository.findListByOpenId(open_id);
    }


    @Override
    public void modify(Long id) {
        listRepository.modify(id);
    }
}
