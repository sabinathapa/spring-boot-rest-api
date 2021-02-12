package com.rest.webapi.user;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import com.rest.webapi.employee.Employee;
import com.rest.webapi.employee.EmployeeDao;
import com.rest.webapi.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long>
        implements UserService {

    private UserDao userDao;
    public UserServiceImpl(){

    }
    @Autowired
    public UserServiceImpl(
            @Qualifier("userDaoImpl") GenericDao<User, Long> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    } {}

    public boolean existsByEmail(String email){
        return false;
    }
}
