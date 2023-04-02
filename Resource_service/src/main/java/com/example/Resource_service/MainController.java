package com.example.Resource_service;

import com.example.Resource_service.service.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MainController {
    private SongService service;

    public MainController(SongService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public String sendPage(){
        return "loadPage";
    }

    @PostMapping("/resources")
    public String upload(MultipartFile multipart) throws Exception {
        String fileName = multipart.getOriginalFilename();
        service.saveSong(fileName, multipart.getInputStream());
        return "message";
    }

}
