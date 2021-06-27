package com.rest.webapi.image;

import com.rest.webapi.base.GenericController;
import com.rest.webapi.util.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


import java.util.*;

@RestController
@RequestMapping(value = "/images")
public class ImageController extends GenericController<Image,Long> {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<FileInfo> upload(@RequestParam("files") MultipartFile[] files, String postId) {
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
            String filename = imageService.save(file);
//                String url = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", filename).build().toString();
            fileNames.add(filename);
            imageService.saveOrUpdate(new Image(filename, postId));
            });
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<List<String>> getParentIdFiles(@PathVariable(value = "id") String id) {
        HashMap<String, String> hm= new HashMap<>();
        hm.put("parentId",id);
        List<Image> results =  imageService.search(hm);

        List<String> urls = new ArrayList<>();

       for(Image img: results){
            String url = MvcUriComponentsBuilder.fromMethodName(ImageController.class, "getFile", img.getFilename()).build().toString();
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



