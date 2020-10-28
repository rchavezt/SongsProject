package com.example.songs.dao;

import com.example.songs.entities.SongEntity;
import org.springframework.data.repository.CrudRepository;

public interface SongDao extends CrudRepository<SongEntity, Long> {
}
