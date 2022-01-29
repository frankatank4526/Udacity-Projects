package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    FileService fileService;

    UserService userService;

    public FileController(FileService fileService, UserService userService){
        this.fileService = fileService;
        this.userService = userService;
    }
    @PostMapping("/file/fileUpload")
    public String postFile(@RequestParam("fileUpload")MultipartFile fileUpload, Authentication authentication,
                           Model model) throws IOException {
        if(this.fileService.getFileByName(fileUpload.getOriginalFilename()) == null) {
            this.fileService.insertFile(fileUpload, userService.getUser(authentication.getName()).getUserId());

            return "redirect:/result?success=true&errorMsg=0";
        }
        else{
            return "redirect:/result?success=false&errorMsg=1";
        }
    }

    @GetMapping("/file/view/{fileId}")
    public ResponseEntity<ByteArrayResource> viewFile(@PathVariable("fileId") Integer fileId, Authentication authentication){

        if(this.userService.getUser(authentication.getName()).getUserId() == this.fileService.findFile(fileId).getUserId()) {
            File files = fileService.findFile(fileId);

            ByteArrayResource byteArrayResource = new ByteArrayResource(files.getFiledata());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(files.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                            files.getFileName() + "\"").body(new ByteArrayResource(files.getFiledata()));

        }
        else{
            return ResponseEntity.ok(null);
        }

    }
    @GetMapping("/file/delete/{fileId}")
    public String deleteFile(@PathVariable("fileId") Integer fileId, Authentication authentication){
        if(this.userService.getUser(authentication.getName()).getUserId() == this.fileService.findFile(fileId).getUserId()) {
            this.fileService.deleteFile(fileId);
            return "redirect:/result?success=true";
        }
        else{
            return "redirect:/result?success=false&errorMsg=2";
        }

    }
}
