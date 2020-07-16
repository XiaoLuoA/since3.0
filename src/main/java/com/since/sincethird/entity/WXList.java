package com.since.sincethird.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @author 王英豪111
 */
@Entity
@Data
@Table(name = "wx_list")
public class WXList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_id")
    private String bookId;

    @Column(name="book_image")
    private String bookImage;

    @Column(name="book_name")
    private String bookName;

    @Column(name="book_price")
    private int bookPrice;

    @Column(name="book_num")
    private int bookNum;


    private int status;

    private String no;

    private String phone;

    @Column(name="wx_name")
    private String wxName;

    @Column(name="wx_image")
    private String wxImage;

    @Column(name="open_id")
    private String openId;

    private String address;
    private int total;

}
