package com.rest.webapi.image;

import com.rest.webapi.base.GenericController;
import com.rest.webapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/images")
public class ImageController extends GenericController<Image,Long> { }



