package com.rest.webapi.user;

import com.rest.webapi.base.GenericController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends GenericController<User,Long> { }



