package com.rest.webapi.security;

import com.rest.webapi.base.GenericService;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginUserService  extends GenericService<LoginUser, Long> {
    UserDetails loadUserByUsername(String username);
    void register(AuthenticationRequest request);
}
