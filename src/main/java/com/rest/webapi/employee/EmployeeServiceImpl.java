package com.rest.webapi.employee;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Long>
        implements EmployeeService {

    private EmployeeDao employeeDao;
    public EmployeeServiceImpl(){

    }
    @Autowired
    public EmployeeServiceImpl(
            @Qualifier("employeeDaoImpl") GenericDao<Employee, Long> genericDao) {
        super(genericDao);
        this.employeeDao = (EmployeeDao) genericDao;
    } {}
}
