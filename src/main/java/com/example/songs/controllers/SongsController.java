package com.example.songs.controllers;

import com.example.songs.dto.SongDto;
import com.example.songs.services.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private Songs songs;

    List<SongDto> song1=new ArrayList<>();

    public List<SongDto> getSong1() {
        SongDto songDto = new SongDto();
        songDto.setArtist("Kiss");
        songDto.setAlbum("Kiss");
        songDto.setName("Rock and roll all night");

        song1.add(songDto);

        return song1;
    }

    List<String> song2=new ArrayList<String>();

    public List<String> getSong2() {
        song2.add("St Petes");
        song2.add("SuicideYear");
        song2.add("Japan");

        return song2;
    }

    List<String> song3= new ArrayList<String>();

    public List<String> getSong3(){
        song3.add("Tsurugi no mai");
        song3.add("Nujabes");
        song3.add("Samurai Champloo");

        return song3;
    }


    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    List<List<String>> amalgama=new ArrayList<>(Collections.emptyList());

    public List<List<String>> getAmalgama(){
        amalgama.add(song1);
        amalgama.add(song2);
        amalgama.add(song3);
        List<String> cancion=amalgama.get(getRandom(0,3));

        return getAmalgama();
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public SongDto getSong(){
        return songs.getSong();
    }



    @RequestMapping(value = "/{song}", method = RequestMethod.GET)
    public String getSongUrl(@PathVariable String song){
        return song;
    }

    @RequestMapping(value = { "/mapping/{param1}" }, method = { RequestMethod.GET})
    public void mapping(HttpServletResponse response, @PathVariable("param1") String param1, @RequestParam(required = true, value = "https://open.spotify.com/album/5iTTqogtbo5iGG5oqTRZuw") String redirectLink) throws IOException {
        response.sendRedirect(redirectLink);
    }
}
