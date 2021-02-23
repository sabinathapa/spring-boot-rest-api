package com.rest.webapi.security;

import com.rest.webapi.base.GenericDao;

public interface LoginUserDao extends GenericDao<LoginUser, Long> {
    LoginUser getUserByUsernameAndPassword(String username, String password);
}
