package com.rest.webapi.employee;

import com.rest.webapi.base.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long>
        implements EmployeeDao {}