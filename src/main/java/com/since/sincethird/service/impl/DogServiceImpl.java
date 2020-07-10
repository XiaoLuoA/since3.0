package com.since.sincethird.service.impl;

import com.since.sincethird.entity.Dog;
import com.since.sincethird.repository.DogRepository;
import com.since.sincethird.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxinyuan
 */
@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public Dog findById(Integer id) {
        return  dogRepository.findById(id).get();
    }
}
