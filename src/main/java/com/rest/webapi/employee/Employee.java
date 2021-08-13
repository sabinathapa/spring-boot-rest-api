package com.rest.webapi.employee;

import com.rest.webapi.base.BaseModel;

import javax.persistence.*;

@Entity
public class Employee extends BaseModel {

    private String firstname;
    private String lastname;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
