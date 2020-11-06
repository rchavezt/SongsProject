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
import java.util.Optional;
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
        Optional<SongEntity> optionalSongEntity = songDao.findById(id);

        if(optionalSongEntity.isEmpty()){
            throw new BadRequestException("Limites fuera de rango");
        }

        SongEntity song = optionalSongEntity.get();

        SongDto songDto = new SongDto();
        songDto.setId(song.getId());
        songDto.setName(song.getName());
        songDto.setArtist(song.getArtist());
        songDto.setAlbum(song.getAlbum());
        songDto.setYTUrl(song.getYTUrl());

        return songDto;
    }

    @Override
    public void deleteSongById(Long id) {
        songDao.deleteById(id);
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
        List<SongDto> songList = new ArrayList<>();

        for (int i =0 ; i<2 ; i++){
            SongEntity song = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

            SongDto songDto = new SongDto();
            songDto.setId(song.getId());
            songDto.setName(song.getName());
            songDto.setArtist(song.getArtist());
            songDto.setAlbum(song.getAlbum());
            songDto.setYTUrl(song.getYTUrl());

            songList.add(songDto);
        }

        return songList;

        /*SongEntity song1 = songDao.findById(new Long(ThreadLocalRandom.current().nextInt(1, 4))).get();

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
        songDto2.setYTUrl(song2.getYTUrl()); */
    }

    @Override
    public String getYTUrl(String name) {
        SongEntity song = songDao.findByName(name);
        return song.getYTUrl();
    }
}


