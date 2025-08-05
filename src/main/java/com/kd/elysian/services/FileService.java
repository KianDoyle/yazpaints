package com.kd.elysian.services;

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
        } catch (Exception e) {
            return new File();
        }
    }
}
