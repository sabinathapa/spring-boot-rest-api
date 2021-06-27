package com.rest.webapi.business;

import com.rest.webapi.base.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessDaoImpl extends GenericDaoImpl<Business, Long>
        implements BusinessDao {}