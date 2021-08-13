package com.rest.webapi.consumerApp;

import com.rest.webapi.base.GenericConsumerAppController;
import com.rest.webapi.business.Business;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("ConsumerAppBusinessController")
@RequestMapping(value = "/v1/business")
public class BusinessController extends GenericConsumerAppController<Business, Long> {

}



