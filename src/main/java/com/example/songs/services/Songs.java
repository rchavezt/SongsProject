package com.example.songs.services;

import com.example.songs.dto.SongDto;
import com.example.songs.entities.SongEntity;

import java.util.List;

public interface Songs {
    SongDto getSong();
    SongDto getSongById(Long id);
    SongDto deleteSongById(Long id);
    List<SongDto> getSongs(Integer number);
    List<SongDto> getTwoSongs();
    SongDto getYTUrl(String song);
    SongDto createSong(SongDto songDto);
}
