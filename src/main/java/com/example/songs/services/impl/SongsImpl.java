package com.example.songs.services.impl;

import com.example.songs.dao.SongDao;
import com.example.songs.dto.SongDto;
import com.example.songs.entities.SongEntity;
import com.example.songs.exceptions.BadRequestException;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SongsImpl implements Songs {

    @Autowired
    SongDao songDao;

    @Override
    public SongDto getSong() {

        List<SongDto> songList = new ArrayList<>();

        SongDto song1 = new SongDto();
        SongDto song2 = new SongDto();
        SongDto song3 = new SongDto();

        song1.setName("Livin on a prayer");
        song1.setAlbum("Bon Jovi");
        song1.setArtist("Bon Jovi");


        SongEntity songEntity1 = new SongEntity();

        songEntity1.setName(song1.getName());
        songEntity1.setAlbum(song1.getAlbum());
        songEntity1.setArtist(song1.getArtist());
        songEntity1.setYTUrl(song1.getYTUrl());

        songEntity1 = songDao.save(songEntity1);

        song1.setId(songEntity1.getId());


        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");


        SongEntity songEntity2 = new SongEntity();

        songEntity2.setName(song2.getName());
        songEntity2.setAlbum(song2.getAlbum());
        songEntity2.setArtist(song2.getArtist());
        songEntity2.setYTUrl(song2.getYTUrl());

        songEntity2 = songDao.save(songEntity2);

        song2.setId(songEntity2.getId());


        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");


        SongEntity songEntity3 = new SongEntity();

        songEntity3.setName(song3.getName());
        songEntity3.setAlbum(song3.getAlbum());
        songEntity3.setArtist(song3.getArtist());
        songEntity3.setYTUrl(song3.getYTUrl());

        songEntity3 = songDao.save(songEntity3);

        song3.setId(songEntity3.getId());

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


        SongEntity songEntity1 = new SongEntity();

        songEntity1.setName(song1.getName());
        songEntity1.setAlbum(song1.getAlbum());
        songEntity1.setArtist(song1.getArtist());
        songEntity1.setYTUrl(song1.getYTUrl());

        songEntity1 = songDao.save(songEntity1);

        song1.setId(songEntity1.getId());


        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");


        SongEntity songEntity2 = new SongEntity();

        songEntity2.setName(song2.getName());
        songEntity2.setAlbum(song2.getAlbum());
        songEntity2.setArtist(song2.getArtist());
        songEntity2.setYTUrl(song2.getYTUrl());

        songEntity2 = songDao.save(songEntity2);

        song2.setId(songEntity2.getId());


        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");


        SongEntity songEntity3 = new SongEntity();

        songEntity3.setName(song3.getName());
        songEntity3.setAlbum(song3.getAlbum());
        songEntity3.setArtist(song3.getArtist());
        songEntity3.setYTUrl(song3.getYTUrl());

        songEntity3 = songDao.save(songEntity3);

        song3.setId(songEntity3.getId());

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


        SongEntity songEntity1 = new SongEntity();

        songEntity1.setName(song1.getName());
        songEntity1.setAlbum(song1.getAlbum());
        songEntity1.setArtist(song1.getArtist());
        songEntity1.setYTUrl(song1.getYTUrl());

        songEntity1 = songDao.save(songEntity1);

        song1.setId(songEntity1.getId());


        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");


        SongEntity songEntity2 = new SongEntity();

        songEntity2.setName(song2.getName());
        songEntity2.setAlbum(song2.getAlbum());
        songEntity2.setArtist(song2.getArtist());
        songEntity2.setYTUrl(song2.getYTUrl());

        songEntity2 = songDao.save(songEntity2);

        song2.setId(songEntity2.getId());


        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");


        SongEntity songEntity3 = new SongEntity();

        songEntity3.setName(song3.getName());
        songEntity3.setAlbum(song3.getAlbum());
        songEntity3.setArtist(song3.getArtist());
        songEntity3.setYTUrl(song3.getYTUrl());

        songEntity3 = songDao.save(songEntity3);

        song3.setId(songEntity3.getId());

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
        List<SongDto> songList = new ArrayList<>();

        SongDto song1 = new SongDto();
        SongDto song2 = new SongDto();
        SongDto song3 = new SongDto();

        song1.setName("Livin on a prayer");
        song1.setAlbum("Bon Jovi");
        song1.setArtist("Bon Jovi");
        song1.setYTUrl("url de yutub :D");

        SongEntity songEntity1 = new SongEntity();

        songEntity1.setName(song1.getName());
        songEntity1.setAlbum(song1.getAlbum());
        songEntity1.setArtist(song1.getArtist());
        songEntity1.setYTUrl(song1.getYTUrl());

        songEntity1 = songDao.save(songEntity1);

        song1.setId(songEntity1.getId());


        song2.setName("Back in black");
        song2.setAlbum("Back in black");
        song2.setArtist("AC/DC");
        song2.setYTUrl("url de yutub :D");


        SongEntity songEntity2 = new SongEntity();

        songEntity2.setName(song2.getName());
        songEntity2.setAlbum(song2.getAlbum());
        songEntity2.setArtist(song2.getArtist());
        songEntity2.setYTUrl(song2.getYTUrl());

        songEntity2 = songDao.save(songEntity2);

        song2.setId(songEntity2.getId());


        song3.setName("El Ansioso");
        song3.setAlbum("Marrano");
        song3.setArtist("Grupo marrano");
        song3.setYTUrl("url de yutub :D");


        SongEntity songEntity3 = new SongEntity();

        songEntity3.setName(song3.getName());
        songEntity3.setAlbum(song3.getAlbum());
        songEntity3.setArtist(song3.getArtist());
        songEntity3.setYTUrl(song3.getYTUrl());

        songEntity3 = songDao.save(songEntity3);

        song3.setId(songEntity3.getId());

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        if (song.equals("Back in black") ) {
            return song1.getYTUrl();
        } else if (song.equals("Livin on a prayer")){
            return song2.getYTUrl();
        } else if (song.equals("El ansioso")){
        return song3.getYTUrl();
        } else {
            return "Solo tengo urls para Back in black, El ansioso o Livin on a prayer como parámetros joven, ahí disculpe";
        }
        }

    @Override
    public SongDto createSong(SongDto songDto) {
        SongEntity songEntity = new SongEntity();

        songEntity.setName(songDto.getName());
        songEntity.setAlbum(songDto.getAlbum());
        songEntity.setArtist(songDto.getArtist());
        songEntity.setYTUrl(songDto.getYTUrl());

        songEntity = songDao.save(songEntity);

        songDto.setId(songEntity.getId());

        return songDto;
    }
}


