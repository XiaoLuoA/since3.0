package com.since.sincethird.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wx_list")
public class WXList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String book_id;
    private String book_image;
    private int book_price;
    private int book_num;
    private int status;
    private String wx_name;
    private String wx_image;
    private String open_id;
    private String address;
    private int total;

}
