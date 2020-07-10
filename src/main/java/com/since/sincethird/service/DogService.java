package com.since.sincethird.service;

import com.since.sincethird.entity.Dog;

/**
 * @author luoxinyuan
 */
public interface DogService {


    /**
     * 通过id获取一条狗
     * @param id 狗主键
     * @return Dog
     */
    Dog findById(Integer id);



}
