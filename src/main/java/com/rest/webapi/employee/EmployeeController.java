package com.rest.webapi.employee;

import com.rest.webapi.base.GenericController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController extends GenericController<Employee, Long>{

}



