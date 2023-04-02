package com.repository;

import com.models.Song;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SongRepository extends CrudRepository<Song,Integer> {

    @Modifying
    @Query("DELETE FROM Song e WHERE e.songId IN :ids")
    void deleteByIdList(@Param("ids") List<Integer> ids);
}
