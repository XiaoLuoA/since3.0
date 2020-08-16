package com.since.sincethird.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author jayzh
 */
@Entity
@Data
@Accessors(chain = true)
@Table(name = "report")
public class Ruser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String sid;
    String password;
    String email;
    String openid;
    Integer day;
    Integer okday;
    Integer status;
}
