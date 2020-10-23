package com.example.songs.controllers;

import com.example.songs.dto.SongDto;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


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

}

