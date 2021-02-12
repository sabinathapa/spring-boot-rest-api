package com.rest.webapi.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    // /greeting?name=Sabina
    @GetMapping("/{id}")
    public ResponseEntity<Image> getImage(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(imageService.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAll() {
        return new ResponseEntity<>(imageService.getAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@RequestBody Image image) {
       imageService.saveOrUpdate(image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Image image) {
        imageService.saveOrUpdate(image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
imageService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



