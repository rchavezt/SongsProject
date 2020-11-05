package com.example.songs.services.impl;

import com.example.songs.dao.SongDao;
import com.example.songs.dto.SongDto;
import com.example.songs.entities.SongEntity;
import com.example.songs.exceptions.BadRequestException;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SongsImpl implements Songs {

    @Autowired
    SongDao songDao;

    @Override
    public SongDto getSong() {
        SongEntity song = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

        SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setName(song.getName());
        songDto.setArtist(song.getArtist());
        songDto.setAlbum(song.getAlbum());
        songDto.setYTUrl(song.getYTUrl());

        return songDto;
    }

    @Override
    public SongDto getSongById(Long id) {
        SongEntity song = songDao.findById(id).get();

        SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setName(song.getName());
        songDto.setArtist(song.getArtist());
        songDto.setAlbum(song.getAlbum());
        songDto.setYTUrl(song.getYTUrl());

        if(id<1 || id>4){
            throw new BadRequestException("Limites fuera de rango");
        } else {
            return songDto;
        }
    }

    @Override
    public SongDto deleteSongById(Long id) {


        if(id<1 || id>4){
            throw new BadRequestException("Limites fuera de rango");
        } else {
            songDao.deleteById(id);
        }
        return null;
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

    @Override
    public List<SongDto> getSongs(Integer number) {
        
        List<SongDto> songList = new ArrayList<>();


        List<SongDto> returnedSongList = new ArrayList<>();


        for (int i =0; i <  number; i++){
            SongEntity song = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

            SongDto songDto = new SongDto();
            songDto.setId(song.getId());
            songDto.setName(song.getName());
            songDto.setArtist(song.getArtist());
            songDto.setAlbum(song.getAlbum());
            songDto.setYTUrl(song.getYTUrl());
            songList.add(songDto);

            returnedSongList.add(songList.get(i));
        }

        return returnedSongList;
    }

    @Override
    public List<SongDto> getTwoSongs() {
        SongEntity song1 = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

        SongDto songDto1 = new SongDto();
        songDto1.setId(song1.getId());
        songDto1.setName(song1.getName());
        songDto1.setArtist(song1.getArtist());
        songDto1.setAlbum(song1.getAlbum());
        songDto1.setYTUrl(song1.getYTUrl());

        SongEntity song2 = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

        SongDto songDto2 = new SongDto();
        songDto2.setId(song2.getId());
        songDto2.setName(song2.getName());
        songDto2.setArtist(song2.getArtist());
        songDto2.setAlbum(song2.getAlbum());
        songDto2.setYTUrl(song2.getYTUrl());

        List<SongDto> songList = new ArrayList<>();
        songList.add(songDto1);
        songList.add(songDto2);



        return songList;

    }

    @Override
    public SongDto getYTUrl(String song) {
        SongEntity song1= songDao.findById(new Long(1)).get();
        SongDto songDto1 = new SongDto();
        songDto1.setYTUrl(song1.getYTUrl());

        SongEntity song2 = songDao.findById(new Long(2)).get();
        SongDto songDto2 = new SongDto();
        songDto2.setYTUrl(song2.getYTUrl());

        SongEntity song3 = songDao.findById(new Long(3)).get();
        SongDto songDto3 = new SongDto();
        songDto3.setYTUrl(song3.getYTUrl());


        if (song.equals("Back in black") ) {
            return songDto1;
        } else if (song.equals("Welcome to the jungle")){
            return songDto2;
        } else if (song.equals("Automation")){
        return songDto3;
        } else {
            return null;
        }
        }
}


