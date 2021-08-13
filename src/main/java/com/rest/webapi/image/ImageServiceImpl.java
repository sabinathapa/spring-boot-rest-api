package com.rest.webapi.image;

import com.rest.webapi.base.GenericDao;
import com.rest.webapi.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageServiceImpl extends GenericServiceImpl<Image, Long>
        implements ImageService {

    private ImageDao imageDao;
    public ImageServiceImpl(){

    }
    @Autowired
    public ImageServiceImpl(
            @Qualifier("imageDaoImpl") GenericDao<Image, Long> genericDao) {
        super(genericDao);
        this.imageDao = (ImageDao) genericDao;
    } {}

    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public String save(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            //this genrates unique file name
            String id = UUID.randomUUID().toString();
            //we are splitting file name here such that we can get file name and extension differently
            String[] fileNameSplits = fileName.split("\\.");
            // extension is assumed to be the last part
            int extensionIndex = fileNameSplits.length - 1;
            // add extension to id
            String newfilename= id + "." + fileNameSplits[extensionIndex];
            Files.copy(file.getInputStream(), this.root.resolve(newfilename));

            return newfilename;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
