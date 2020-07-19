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
    @Column(name = "wx_name")
    private String wxName;
    @Column(name = "wx_image")
    private String wxImage;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "wx_address")
    private String wxAddress;
    private String message;
    @Column(name = "message_time")
    private String messageTime;
    private Integer status;

    
}
