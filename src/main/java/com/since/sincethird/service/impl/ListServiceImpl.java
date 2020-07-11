package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import com.since.sincethird.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 王英豪111
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ListServiceImpl implements ListService {


    @Autowired
    private ListRepository listRepository;

    @Override
    public WXList save(WXList wxList) {
        return listRepository.save(wxList);
    }


    @Override
    public List<WXList> findListByOpenId(String open_id) {
        return listRepository.findAllByOpenId(open_id);
    }

    @Override
    public WXList findWXListById(Long id) {
        return listRepository.findWXListById(id);
    }


}
