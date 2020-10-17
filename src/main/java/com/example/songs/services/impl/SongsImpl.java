package com.example.songs.services.impl;

import com.example.songs.dto.SongDto;
import com.example.songs.services.Songs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SongsImpl implements Songs {

    @Override
    public SongDto getSong() {
        List<SongDto> songList = new ArrayList<>();

        SongDto song1 = new SongDto();
        SongDto song2 = new SongDto();
        SongDto song3 = new SongDto();

        song1.setName("Livin on a prayer");
        song1.setAlbum("Bon Jovi");
        song1.setArtist("Bon Jovi");

        song2.setName("Back in black");
        song2.setAlbum("Back in blacl");
        song2.setArtist("AC/DC");

        song3.setName("Ansionso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        return songList.get(ThreadLocalRandom.current().nextInt(0, 3));
    }
}
