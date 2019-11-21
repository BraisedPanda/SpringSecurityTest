package com.braisedpanda.commons.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: admin-dashboard
 * @description:

 * @create: 2019-11-20 11:12
 **/
@Data
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 6799918272107449814L;
    @Id
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "status")
    private Integer status;
}
