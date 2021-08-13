package com.rest.webapi.business;

import com.rest.webapi.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Business extends BaseModel {


    @NotBlank(message = "Name is required.")
    private String name;
    private String about;
    @NotBlank(message = "Address is required.")
    private String address;
    @NotBlank(message = "Phone is required.")
    private String phone;
    @NotBlank(message = "Email is required.")
    private String email;
    private String website;
    private String[] socialSites;
    private Date createdDateTime;
    private String createdBy;

}
