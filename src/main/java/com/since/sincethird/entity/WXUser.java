package com.since.sincethird.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wx_user")
public class WXUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String wxName;

    String wxImage;

    String openId;

    String wxAddress;

    String status;
}
