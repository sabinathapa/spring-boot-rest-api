package com.rest.webapi.consumerApp;

import com.rest.webapi.base.GenericConsumerAppController;
import com.rest.webapi.image.Image;
import com.rest.webapi.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController("ConsumerAppImageController")
@RequestMapping(value = "/v1/images")
public class ImageController extends GenericConsumerAppController<Image,Long> {

    @Autowired
    private ImageService imageService;

    @GetMapping("/post/{id}")
    public ResponseEntity<List<String>> getParentIdFiles(@PathVariable(value = "id") String id) {
        HashMap<String, String> hm= new HashMap<>();
        hm.put("parentId",id);
        List<Image> results =  imageService.search(hm);

        List<String> urls = new ArrayList<>();

        for(Image img: results){
            String url = MvcUriComponentsBuilder.fromMethodName(com.rest.webapi.image.ImageController.class, "getFile", img.getFilename()).build().toString();
            urls.add(url);
        };

        return ResponseEntity.status(HttpStatus.OK).body(urls);
    }


    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = imageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}



