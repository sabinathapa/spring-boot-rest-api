package com.rest.webapi.post;

import com.rest.webapi.base.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends GenericDaoImpl<Post, Long>
        implements PostDao {}