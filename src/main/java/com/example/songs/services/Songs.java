package com.example.songs.services;

import com.example.songs.dto.SongDto;

import java.util.List;

public interface Songs {
    SongDto getSong();
    List<SongDto> getSongs(Integer number);
    List<SongDto> getTwoSongs();
    String getYTUrl(String song);
    SongDto createSong(SongDto songDto);
}
