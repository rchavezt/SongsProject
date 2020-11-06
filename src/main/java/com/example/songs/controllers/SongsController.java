package com.example.songs.controllers;

import com.example.songs.dto.SongDto;
import com.example.songs.exceptions.BadRequestException;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private Songs songs;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public SongDto getSong(){
        return songs.getSong();
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public List<SongDto> getSongs(@PathVariable Integer number){
        return songs.getSongs(number);
    }

    @RequestMapping(value="/getTwo", method = RequestMethod.GET)
    public List<SongDto> get2Songs(){
        return songs.getTwoSongs();
    }

    @RequestMapping(value = "/youtube/{song}", method = RequestMethod.GET)
    public String getSongVideo(@PathVariable String song){
        return songs.getYTUrl(song);
    }

    @RequestMapping(value = "/song", method = RequestMethod.POST)
    public SongDto createSong(@RequestBody SongDto songDto){
        return songs.createSong(songDto);
    }

    @RequestMapping(value = "/deletedSong/{id}", method = RequestMethod.DELETE)
    public void deleteSongById(@PathVariable Long id){
        songs.deleteSongById(id);
    }

    @RequestMapping(value="/songId/{id}", method=RequestMethod.GET)
    public SongDto getSongById(@PathVariable Long id){

        if(id < 1){
            throw new BadRequestException("El id no puede ser menor a 1");
        }

        return songs.getSongById(id);
    }
}

