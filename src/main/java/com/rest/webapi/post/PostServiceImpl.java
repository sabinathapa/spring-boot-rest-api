package com.rest.webapi.post;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends GenericServiceImpl<Post, Long> implements PostService {

    private PostDao postDao;
    public PostServiceImpl(){ }

    @Autowired
    public PostServiceImpl(@Qualifier("postDaoImpl") GenericDao<Post, Long> genericDao) {
        super(genericDao);
        this.postDao = (PostDao) genericDao;
    } {}


    public void AddNewPost(PostDao entity) {

    }
}
