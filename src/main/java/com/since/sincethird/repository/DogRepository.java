package com.since.sincethird.repository;
import com.since.sincethird.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoxinyuan
 */
@Repository
public interface DogRepository extends JpaRepository<Dog,Integer> {


    /**
     * 通过name查找一条狗
     * @param name
     * @return
     */
    Dog findDogByName(String name);


    /**
     * 查找大于id的所有狗
     * @param id
     * @return
     */
    List<Dog> findDogsByIdAfter(Integer id);
}
