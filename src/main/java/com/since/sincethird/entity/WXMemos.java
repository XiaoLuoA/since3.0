package com.since.sincethird.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author jayzh
 */
@Entity
@Data
@Table(name = "wx_memos")
public class WXMemos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String wx_name;
    private String wx_image;
    private String open_id;
    private String wx_address;
    private String message;
    private String message_time;
    private String status;
}
