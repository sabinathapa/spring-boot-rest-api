package com.rest.webapi.image;


import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String parentId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Image(String filename, String parentId){
        this.filename=filename;
        this.parentId =parentId;
    }

    public Image(){};
}
