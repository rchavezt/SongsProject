package com.example.songs.controllers;

import com.example.songs.dto.SongDto;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private Songs songs;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public SongDto getSong(){
        return songs.getSong();
    }

    @RequestMapping(value = "/{song}", method = RequestMethod.GET)
    public String getSongUrl(@PathVariable String song){
        return song;
    }
}
