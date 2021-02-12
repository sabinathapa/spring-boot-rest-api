package com.rest.webapi.user;


import com.rest.webapi.base.GenericService;

public interface UserService extends GenericService<User, Long> {
    boolean existsByEmail(String email);
}
