package com.rest.webapi.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericConsumerAppController<T, K>{

    @Autowired
    private GenericService<T, K> genericService;

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable(value = "id") K id) {
        return new ResponseEntity<>(genericService.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return new ResponseEntity<>(genericService.getAll(), HttpStatus.OK);
    }



}
