package com.rest.webapi.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    @NotBlank(message = "Title is required.")
    private String title;
    @NotBlank(message = "Description is required.")
    private String description;
    @NotBlank(message = "Category is required.")
    private String category;
    private char displayPrice;
    private float price;
    private float specialPrice;
    private Date specialPriceExpirationDate;
    private Date createdDateTime;
    private String createdBy;

}
