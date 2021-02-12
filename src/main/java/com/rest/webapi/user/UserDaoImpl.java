package com.rest.webapi.user;

import com.rest.webapi.base.GenericDaoImpl;
import com.rest.webapi.employee.Employee;
import com.rest.webapi.employee.EmployeeDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long>
        implements UserDao {}