package com.rest.webapi.business;

import com.rest.webapi.base.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/business")
public class BusinessController extends GenericController<Business, Long>{

}



