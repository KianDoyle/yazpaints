package com.kd.elysian.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kd.elysian.models.File;
import com.kd.elysian.services.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
    
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<File> uploadFile(@RequestParam MultipartFile multipartFile) {
        File file = fileService.saveFileToBucket(multipartFile);
        
        if (file.getId() == null) {
            return ResponseEntity.status(500).body(file);
        }

        return ResponseEntity.ok(file);
    }
}
