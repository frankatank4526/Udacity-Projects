package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public List<File> getFiles(int userId){
        return this.fileMapper.getAllFiles(userId);
    }
    public File findFile(Integer fileId){
        return this.fileMapper.getFile(fileId);
    }
    public File getFileByName(String fileName) { return this.fileMapper.getFileByName(fileName);}
    public void insertFile(MultipartFile file, Integer userId) throws IOException {
        File fileToInsert = new File(null, file.getOriginalFilename(), file.getContentType(), Long.toString(file.getSize()),
                userId, file.getBytes());
        this.fileMapper.insertFile(fileToInsert);
    }
    public void deleteFile(Integer fileId){
        this.fileMapper.deleteFile(fileId);

    }

}
