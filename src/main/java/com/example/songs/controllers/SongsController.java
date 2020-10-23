package com.example.songs.controllers;

import com.example.songs.dto.SongDto;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private Songs songs;



    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public SongDto getSong(){
        return songs.getSong();
    }

    @RequestMapping(value = "/www.youtube.com/results?search_query={song}", method = RequestMethod.GET)
    public String getSongUrl(@PathVariable String song){
        return song;
    }

    @RequestMapping(value="/{song}", method = RequestMethod.GET)
    public ModelAndView getSongVideo(@org.jetbrains.annotations.NotNull @PathVariable Map<String,String> song){

        String rola=song.get("song");

        ModelAndView model=new ModelAndView("Link");
        model.addObject("msg","www.youtube.com/results?search_query="+rola);

        return model;
    }

    }

