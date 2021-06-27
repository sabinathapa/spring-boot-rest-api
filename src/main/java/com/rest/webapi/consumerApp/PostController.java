package com.rest.webapi.consumerApp;

import com.rest.webapi.base.GenericController;
import com.rest.webapi.post.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("ConsumerAppPostController")
@RequestMapping(value = "/v1/posts")
public class PostController extends GenericController<Post, Long>{

}



