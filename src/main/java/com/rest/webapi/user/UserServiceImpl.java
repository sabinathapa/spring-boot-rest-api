package com.rest.webapi.user;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long>
        implements UserService {

    @Autowired
    private UserDao userDao;

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
