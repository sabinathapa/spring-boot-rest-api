package com.rest.webapi.business;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
