package com.services;

import com.models.Song;
import org.springframework.stereotype.Service;
import com.repository.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public Song saveSong(Song song){
        return repository.save(song);
    }

    public Optional<Song> findSong(Integer id){
        return repository.findById(id);
    }

    public void deleteSongs(List<Integer> ids){
        repository.deleteByIdList(ids);
    }
}
