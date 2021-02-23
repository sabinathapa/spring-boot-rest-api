package com.rest.webapi.security;


import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class LoginUserServiceImpl extends GenericServiceImpl<LoginUser, Long> implements LoginUserService, UserDetailsService {

    @Autowired
    private LoginUserDao loginUserDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    public LoginUserServiceImpl(
            @Qualifier("loginUserDaoImpl") GenericDao<LoginUser, Long> genericDao) {
        super(genericDao);
        this.loginUserDao = (LoginUserDao) genericDao;
    }

    {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashMap<String, String> hasm = new HashMap<String, String>();
        hasm.put("username", username);
        return new CustomUserDetails((LoginUser) this.loginUserDao.search(hasm).get(0));
    }

    public void register(AuthenticationRequest request) {
        LoginUser newUser = new LoginUser();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(bcryptEncoder.encode(request.getPassword()));
        newUser.setRole("User");
        newUser.setEnabled(true);
        this.loginUserDao.saveOrUpdate(newUser);
    }

}
