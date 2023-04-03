package com.example.Resource_service;

import com.example.Resource_service.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MainController {
    private SongService service;

    public MainController(SongService service) {
        this.service = service;
    }
    @PostMapping("/resources")
    public String upload(MultipartFile multipart) throws Exception {
        String fileName = multipart.getOriginalFilename();
        service.saveSong(fileName, multipart.getInputStream());
        return "message";
    }
    @GetMapping("resources/{id}")
    public ResponseEntity<Object> download(@PathVariable Integer id) throws Exception{
        var response=service.findSong(id);
        if (response==null){
            return new ResponseEntity<>("The resource with the specified id does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/resources")
    public ResponseEntity<Object> deleteSong(@RequestParam List<Integer> ids){
        service.deleteSongs(ids);
        return new ResponseEntity(ids,HttpStatus.OK);
    }
}
