package com.rest.webapi.image;


import com.rest.webapi.base.BaseModel;

import javax.persistence.*;

@Entity
public class Image extends BaseModel {

    private String filename;
    private String parentId;

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
