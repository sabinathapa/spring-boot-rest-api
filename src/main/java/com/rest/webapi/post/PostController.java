package com.rest.webapi.post;

import com.rest.webapi.base.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/posts")
public class PostController extends GenericController<Post, Long>{

}



