package com.example.songs.services.impl;

import com.example.songs.dto.SongDto;
import com.example.songs.exceptions.BadRequestException;
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
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");

        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);


        return songList.get(ThreadLocalRandom.current().nextInt(0, 3));
    }

    @Override
    public List<SongDto> getSongs(Integer number) {
        List<SongDto> songList = new ArrayList<>();

        SongDto song1 = new SongDto();
        SongDto song2 = new SongDto();
        SongDto song3 = new SongDto();

        song1.setName("Livin on a prayer");
        song1.setAlbum("Bon Jovi");
        song1.setArtist("Bon Jovi");

        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");

        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        if (number > songList.size() || number <= 0) {
            throw new BadRequestException("Limites fuera de rango");
        }

        List<SongDto> returnedSongList = new ArrayList<>();

        for (int i =0; i <  number; i++){
            returnedSongList.add(songList.get(ThreadLocalRandom.current().nextInt(0, 3)));
        }

        return returnedSongList;
    }

    @Override
    public List<SongDto> getTwoSongs() {
        List<SongDto> songList = new ArrayList<>();

        SongDto song1 = new SongDto();
        SongDto song2 = new SongDto();
        SongDto song3 = new SongDto();

        song1.setName("Livin on a prayer");
        song1.setAlbum("Bon Jovi");
        song1.setArtist("Bon Jovi");

        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");

        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);



        List<SongDto> returnedSongList = new ArrayList<>();

        for (int i =0; i <  2; i++){
            returnedSongList.add(songList.get(ThreadLocalRandom.current().nextInt(0, 3)));
        }

        return returnedSongList;

    }

    @Override
    public String getYTUrl(String song) {
        if (song.equals("Back in black") ) {
            return "URL al video: https://www.youtube.com/watch?v=pAgnJDJN4VA";
        } else if (song.equals("Livin on a prayer")){
            return "URL al video: https://www.youtube.com/watch?v=lDK9QqIzhwk";
        } else if (song.equals("El ansioso")){
        return "URL al video: https://www.youtube.com/watch?v=3-Z-pzxiUAs";
        } else {
            return "Solo tengo urls para Back in black, El ansioso o Livin on a prayer como parámetros joven, ahí disculpe";
        }
        }
    }


