package com.since.sincethird.repository;

import com.since.sincethird.entity.Book;
import com.since.sincethird.entity.WXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRep extends JpaRepository<Book,Long> {



}
