package com.rest.webapi.user;

import com.rest.webapi.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;



}
