package com.example.Resource_service.service;

import com.example.Resource_service.models.SongInfo;
import com.example.Resource_service.repository.Resources;
import com.example.Resource_service.repository.S3repository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    Resources repository;
    S3repository s3repository;

    public SongService(Resources repository,S3repository s3repository) {
        this.s3repository=s3repository;
        this.repository = repository;
    }

    public SongInfo saveSong(String fileName, InputStream inputStream) throws Exception {
        var info=new SongInfo();
        info.setFileKey(fileName);
        s3repository.uploadFile(fileName,inputStream);
        return repository.save(info);
    }

    public Optional<SongInfo> findSong(Integer id) {
        return repository.findById(id);
    }

    public void deleteSongs(List<Integer> ids) {
        repository.deleteByIdList(ids);
    }
}
