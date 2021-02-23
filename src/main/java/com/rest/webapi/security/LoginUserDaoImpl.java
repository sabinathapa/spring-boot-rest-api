package com.rest.webapi.security;

import com.rest.webapi.base.GenericDaoImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LoginUserDaoImpl extends GenericDaoImpl<LoginUser, Long>
        implements LoginUserDao {
    @Override
    public LoginUser getUserByUsernameAndPassword(String username, String password) {
        HashMap<String, String> hasm = new HashMap<String, String>();
        hasm.put("username", username);
        hasm.put("password", password);
       // List<LoginUser> result = search(hasm);
        return search(hasm).get(0);
    }

}