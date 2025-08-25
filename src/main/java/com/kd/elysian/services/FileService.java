package com.kd.elysian.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kd.elysian.models.File;
import com.kd.elysian.repositories.FileRepository;

@Service
public class FileService {
    
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFileToBucket(MultipartFile multipartFile) {
        String bucketUrl = "some/bucket/url/"; // Replace with actual bucket URL
        String filename = multipartFile.getOriginalFilename();
        
        try {
            multipartFile.transferTo(new java.io.File(bucketUrl + filename));
            File file = new File(null, filename, multipartFile.getContentType(), bucketUrl + filename);
            File resFile = fileRepository.save(file);
            return resFile;
        } catch (IOException | IllegalStateException e) {
            return new File();
        }
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Integer id) {
        return fileRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("File with ID " + id + " does not exist."));
    }

    public File deleteFile(Integer id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("File with ID " + id + " does not exist."));
        fileRepository.delete(file);
        return file;
    }
}
