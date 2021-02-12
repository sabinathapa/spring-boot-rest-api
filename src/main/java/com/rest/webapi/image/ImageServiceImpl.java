package com.rest.webapi.image;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import com.rest.webapi.employee.Employee;
import com.rest.webapi.employee.EmployeeDao;
import com.rest.webapi.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends GenericServiceImpl<Image, Long>
        implements ImageService {

    private ImageDao imageDao;
    public ImageServiceImpl(){

    }
    @Autowired
    public ImageServiceImpl(
            @Qualifier("imageDaoImpl") GenericDao<Image, Long> genericDao) {
        super(genericDao);
        this.imageDao = (ImageDao) genericDao;
    } {}
}
