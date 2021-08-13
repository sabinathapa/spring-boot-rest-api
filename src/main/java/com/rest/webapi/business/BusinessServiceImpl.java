package com.rest.webapi.business;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
