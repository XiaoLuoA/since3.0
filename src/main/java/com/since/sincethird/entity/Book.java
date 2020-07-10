package com.since.sincethird.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    Booknumb;
    private String  Bookname;
    private String  Bookwriter;
    private Integer Bookpurprice;
    private Integer Bookprice;
    private Integer Bookclick;
    private Integer Bookcount;
    private String  Bookimage1;
    private String  Bookimage2;
    private String  Bookimage3;
    private String  Booktime;
    private Integer Bookzan;
    private Integer Bookads;
    private Integer Bookstatus;
    private Integer Bookpricing;
    private String  Bookuse;

}
