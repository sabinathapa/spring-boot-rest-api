package com.rest.webapi.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T extends BaseModel, K>{

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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@RequestBody T object) {
        genericService.saveOrUpdate(object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody T object) {
        genericService.saveOrUpdate(object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable K id) {
        genericService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
