package com.rest.webapi.image;

import com.rest.webapi.base.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image, Long>
        implements ImageDao {}