package com.rest.webapi.consumerApp;

import com.rest.webapi.base.GenericConsumerAppController;
import com.rest.webapi.employee.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("ConsumerAppEmployeeController")
@RequestMapping(value = "/v1/employees")
public class EmployeeController extends GenericConsumerAppController<Employee, Long> {

}



