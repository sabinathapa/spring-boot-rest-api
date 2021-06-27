package com.rest.webapi.business;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import com.rest.webapi.image.Image;
import com.rest.webapi.image.ImageDao;
import com.rest.webapi.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class BusinessServiceImpl extends GenericServiceImpl<Business, Long>
        implements BusinessService {

    private BusinessDao businessDao;
    public BusinessServiceImpl(){

    }
    @Autowired
    public BusinessServiceImpl(
            @Qualifier("businessDaoImpl") GenericDao<Business, Long> genericDao) {
        super(genericDao);
        this.businessDao = (BusinessDao) genericDao;
    } {}

}
