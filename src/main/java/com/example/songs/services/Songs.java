package com.example.songs.services;

import com.example.songs.dto.SongDto;

import java.util.List;

public interface Songs {
    SongDto getSong();
    SongDto getSongById(Long id);
    void deleteSongById(Long id);
    List<SongDto> getSongs(Integer number);
    List<SongDto> getTwoSongs();
    String getYTUrl(String name);
    SongDto createSong(SongDto songDto);
}
